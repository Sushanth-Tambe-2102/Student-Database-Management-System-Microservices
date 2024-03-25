package project.msa.studentworkdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.msa.studentworkdetails.dto.WorkDTO;
import project.msa.studentworkdetails.entity.Work;
import project.msa.studentworkdetails.mapper.Mapper;
import project.msa.studentworkdetails.repository.WorkRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkServiceImplementation implements WorkService{
    @Autowired
    WorkRepository repository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<WorkDTO>> getAllWorkDetails() {
        List<Work> work = repository.findAll();
        return new ResponseEntity<>(
                work
                        .stream()
                        .map(Mapper::mapToWorkDTO)
                        .collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WorkDTO>getWorkDetailsById(long studentId){
        Work work = repository.findById(studentId).orElse(null);
        if(work != null) {
            WorkDTO workdto = Mapper.mapToWorkDTO(work);
            return new ResponseEntity<>(
                    workdto,
                    HttpStatus.OK
            );
        }
        WorkDTO workdto = Mapper.mapToWorkDTO(new Work());
        return new ResponseEntity<>(workdto, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<WorkDTO>addWorkDetails(WorkDTO workdto) {
        try{
            boolean studentExists = restTemplate.getForObject("http://student-personal-details/personal/exists/"+workdto.getStudentId(),boolean.class);
            if(studentExists){
                Work work = Mapper.mapToWork(workdto);
                Work savedWork = repository.save(work);
                return new ResponseEntity<>(
                        Mapper
                                .mapToWorkDTO(savedWork),
                        HttpStatus.CREATED);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(workdto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(workdto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<WorkDTO>updateWorkDetails(WorkDTO workdto) {
        try{
            Work existingWork = repository.findById(workdto.getStudentId()).orElse(null);
            if(existingWork != null) {
                Work work = Mapper.mapToWork(workdto);
                Work updatedWork = repository.save(work);
                return new ResponseEntity<>(
                        Mapper.mapToWorkDTO(updatedWork),
                        HttpStatus.CREATED
                );
            }
            else{
                return new ResponseEntity<>(
                        Mapper.mapToWorkDTO(new Work()),
                        HttpStatus.NOT_FOUND
                );
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    Mapper.mapToWorkDTO(new Work()),
                    HttpStatus.CONFLICT
            );
        }
    }
}
