package project.msa.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.msa.dto.AcademicsDTO;
import project.msa.entity.Academics;
import project.msa.mapper.AcademicMapper;
import project.msa.repository.AcademicRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AcademicServicesImpl implements AcademicService {
    @Autowired
    private AcademicRepository academicRepository;
    @Override
    public ResponseEntity<List<AcademicsDTO>> getAllAcademicDetails() {
        List<Academics> academicsList = academicRepository.findAll();
        return new ResponseEntity<>(
                academicsList
                        .stream()
                        .map(AcademicMapper::maptoAcademicsDTO)
                        .collect(Collectors.toList()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AcademicsDTO> getAcademicDetailById(long StudentId) {
        Academics academics = academicRepository.findById(StudentId).orElse(null);

        if (academics != null) {
            AcademicsDTO academicsDTO = AcademicMapper.maptoAcademicsDTO(academics);
            return new ResponseEntity<>(
                    academicsDTO, HttpStatus.OK
            );
        }

        AcademicsDTO academicsDTO = AcademicMapper.maptoAcademicsDTO(new Academics());
        return new ResponseEntity<>(academicsDTO, HttpStatus.NOT_FOUND);

    }
    @Override
    public ResponseEntity<AcademicsDTO>  addAcademicDetail(AcademicsDTO academicsDTO) {
        try {
            Academics academics = AcademicMapper.maptoAcademics(academicsDTO);
            Academics savedAcademics = academicRepository.save(academics);
            return new ResponseEntity<>(
                    AcademicMapper.maptoAcademicsDTO(savedAcademics), HttpStatus.CREATED);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(
                    new AcademicsDTO(),
                    HttpStatus.CONFLICT
            );

        }
    }


    @Override
    public ResponseEntity<AcademicsDTO>  updateAcademicDetail(AcademicsDTO academicsDTO) {
        try {
            Academics existingAcademics = academicRepository.findById(academicsDTO.getStudentId()).orElse(null);
            if (existingAcademics != null) {
                Academics academics = AcademicMapper.maptoAcademics(academicsDTO);
                Academics updatedAcademics = academicRepository.save(academics);
                return new ResponseEntity<>(
                        AcademicMapper.maptoAcademicsDTO(updatedAcademics),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        AcademicMapper.maptoAcademicsDTO(new Academics()),
                        HttpStatus.NOT_FOUND
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    AcademicMapper.maptoAcademicsDTO(new Academics()),
                    HttpStatus.CONFLICT
            );
        }

    }


}



