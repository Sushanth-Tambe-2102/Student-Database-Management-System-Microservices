package project.msa.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.nio.entity.AbstractCharAsyncEntityConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.msa.dto.StudentDto;
import project.msa.entity.Academics;
import project.msa.entity.Student;
import project.msa.entity.Work;
import project.msa.mapper.Mapper;
import project.msa.repository.StudentRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<List<HashMap<String, Object>>> getAllDetails() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Student> personalDetails = studentRepository.findAll();
            List<Academics> academicDetails = mapper.convertValue(restTemplate.getForObject(
                    "http://student-academic-details/api/v1/academics/get-all-academic-details", List.class),
                    new TypeReference<>(){});
            List<Work> workDetails = mapper.convertValue(restTemplate.getForObject(
                    "http://student-work-details/api/v1/work/get-all-work-details", List.class),
                    new TypeReference<>(){});

            System.out.println(academicDetails);
            List<HashMap<String, Object>> studentsList = new ArrayList<>();

            for (Student s : personalDetails) {
                HashMap<String, Object> temp = new HashMap<>();
                temp.put("Personal Details", s);

                for (Academics a : academicDetails) {
                    if (a.getStudentId() == s.getStudentId()) {
                        temp.put("Academic Details", a);
                    }
                }

                temp.putIfAbsent("Academic Details", new Object());

                for (Work w : workDetails) {
                    if (w.getStudentId() == s.getStudentId()) {
                        temp.put("Work Details", w);
                    }
                }

                temp.putIfAbsent("Work Details", new Object());

                studentsList.add(temp);
            }

            return new ResponseEntity<>(
                    studentsList,
                    HttpStatus.OK
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<HashMap<String, Object>> getAllDetailsById(long studentId) {
        try {
            Student personalDetails = studentRepository.findById(studentId).orElse(null);
            Academics academicDetails = restTemplate.getForObject("http://student-academic-details/api/v1/academics/get-academic-details/" + studentId, Academics.class);
            Work workDetails = restTemplate.getForObject("http://student-work-details/api/v1/work/get-work-details/" + studentId, Work.class);
            HashMap<String, Object> newObject = new HashMap<>();
            System.out.println(personalDetails);
            System.out.println(academicDetails);
            System.out.println(workDetails);
            newObject.put("Personal Details: ", personalDetails);
            newObject.put("Academic Details: ", academicDetails);
            newObject.put("Work Details", workDetails);

            return new ResponseEntity<>(
                    newObject,
                    HttpStatus.OK
            );
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ResponseEntity<List<StudentDto>> getAllPersonalDetails() {
        List<Student> students = studentRepository.findAll();

        return new ResponseEntity<>(
                students
                        .stream()
                        .map(Mapper::mapToStudentDto)
                        .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<StudentDto> getPersonalDetailsById(long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            return new ResponseEntity<>(
                    Mapper.mapToStudentDto(student),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new StudentDto(),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @Override
    public ResponseEntity<StudentDto> addPersonalDetails(StudentDto studentDto) {
        try {
            Student student = Mapper.mapToStudent(studentDto);
            Student savedStudent = studentRepository.save(student);

            return new ResponseEntity<>(
                    Mapper.mapToStudentDto(savedStudent),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new StudentDto(),
                    HttpStatus.CONFLICT
            );
        }
    }

    @Override
    public ResponseEntity<StudentDto> updatePersonalDetails(StudentDto studentDto) {
        try {
            Student tempStudent = studentRepository.findById(studentDto.getStudentId()).orElse(null);

            if(tempStudent != null) {
                Student student = Mapper.mapToStudent(studentDto);
                Student savedStudent = studentRepository.save(student);

                return new ResponseEntity<>(
                        Mapper.mapToStudentDto(savedStudent),
                        HttpStatus.CREATED
                );
            } else {
                return new ResponseEntity<>(
                        new StudentDto(),
                        HttpStatus.NOT_FOUND
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(
                    new StudentDto(),
                    HttpStatus.CONFLICT
            );
        }
    }

    @Override
    public ResponseEntity<Boolean> studentExists(long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if (student != null) {
            return new ResponseEntity<>(
                    true,
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(
                    false,
                    HttpStatus.NOT_FOUND);
        }
    }

}
