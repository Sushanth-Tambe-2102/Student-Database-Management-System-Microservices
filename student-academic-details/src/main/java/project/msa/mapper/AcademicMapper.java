package project.msa.mapper;

import project.msa.dto.AcademicsDTO;
import project.msa.entity.Academics;

public class AcademicMapper {
    public static Academics maptoAcademics(AcademicsDTO academicsDTO){
        return new Academics(
                academicsDTO.getAcademicId(),
                academicsDTO.getStudentId(),
                academicsDTO.getCourse(),
                academicsDTO.getSemester(),
                academicsDTO.getNumSubjects(),
                academicsDTO.getMarksObtained(),
                academicsDTO.getTotalMarks(),
                academicsDTO.getGrade()
        );
    }
    public static AcademicsDTO maptoAcademicsDTO(Academics academics){
      return new AcademicsDTO(
                academics.getAcademicId(),
                academics.getStudentId(),
                academics.getCourse(),
                academics.getSemester(),
                academics.getNumSubjects(),
                academics.getMarksObtained(),
                academics.getTotalMarks(),
                academics.getGrade()
        );
    }
}
