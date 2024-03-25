package project.msa.studentworkdetails.service;

import org.springframework.http.ResponseEntity;
import project.msa.studentworkdetails.dto.WorkDTO;

import java.util.List;

public interface WorkService {
    ResponseEntity<List<WorkDTO>> getAllWorkDetails();
    ResponseEntity<WorkDTO> getWorkDetailsById(long studentId);
    ResponseEntity<WorkDTO> addWorkDetails(WorkDTO workdto);
    ResponseEntity<WorkDTO> updateWorkDetails(WorkDTO workdto);
}
