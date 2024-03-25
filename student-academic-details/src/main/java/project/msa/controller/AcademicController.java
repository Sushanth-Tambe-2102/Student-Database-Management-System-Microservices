package project.msa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.msa.dto.AcademicsDTO;
import project.msa.service.AcademicServicesImpl;

import java.util.List;

@RestController
@RequestMapping("api/v1/academics")
public class AcademicController {
    @Autowired
    AcademicServicesImpl service;
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/get-all-academic-details")
    public ResponseEntity<List<AcademicsDTO>> getAllAcademicDetails() {
        return service.getAllAcademicDetails();
    }
    @GetMapping("/get-academic-details/{studentId}")
    public ResponseEntity<AcademicsDTO> getAcademicDetailbyId(@PathVariable long studentId) {
        return service.getAcademicDetailById(studentId);
    }

    @PostMapping("/add-academic-details")
    public ResponseEntity<AcademicsDTO> addAcademicDetails(@RequestBody AcademicsDTO academicsDTO) {
        boolean studentExists =restTemplate.getForObject(
                "http://student-personal-details/api/v1/personal/exists",
                boolean.class);
        if(studentExists){
            return service.addAcademicDetail(academicsDTO);
        }
        return new ResponseEntity<>(academicsDTO, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update-academic-details")
    public ResponseEntity<AcademicsDTO> updateAcademicDetails(@RequestBody AcademicsDTO academicsDTO) {
        return service.updateAcademicDetail(academicsDTO);
    }




}
