package project.msa.service;

import org.springframework.http.ResponseEntity;
import project.msa.dto.AcademicsDTO;

import java.util.List;

public interface AcademicService {

    ResponseEntity<List<AcademicsDTO>> getAllAcademicDetails();

    ResponseEntity<AcademicsDTO> getAcademicDetailById(long studentId);


    ResponseEntity<AcademicsDTO>  addAcademicDetail(AcademicsDTO academicsDTO);

    ResponseEntity<AcademicsDTO>  updateAcademicDetail(AcademicsDTO academicsDTO);

}
