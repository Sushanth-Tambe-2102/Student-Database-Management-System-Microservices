package project.msa.studentworkdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import project.msa.studentworkdetails.dto.WorkDTO;
import project.msa.studentworkdetails.service.WorkServiceImplementation;

import java.util.List;

@RestController
@RequestMapping("api/v1/work")
public class WorkController {

    @Autowired
    WorkServiceImplementation service;
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/get-all-work-details")
    public ResponseEntity<List<WorkDTO>> getAllWorkDetails() {
        return service.getAllWorkDetails();
    }

    @GetMapping("/get-work-details/{id}")
    public ResponseEntity<WorkDTO> getEmployeeById(@PathVariable long id) {
        return service.getWorkDetailsById(id);
    }


    @PostMapping("/add-work-details")
    public ResponseEntity<WorkDTO> addWorkDetails(@RequestBody WorkDTO workdto) {
        return service.addWorkDetails(workdto);
    }

    @PutMapping("/update-work-details")
    public ResponseEntity<WorkDTO> updateEmployeeById(@RequestBody WorkDTO workdto) {
        return service.updateWorkDetails(workdto);
    }

}
