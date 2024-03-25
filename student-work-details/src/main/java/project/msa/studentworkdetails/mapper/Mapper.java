package project.msa.studentworkdetails.mapper;

import project.msa.studentworkdetails.dto.WorkDTO;
import project.msa.studentworkdetails.entity.Work;

public class Mapper {
    public static WorkDTO mapToWorkDTO(Work work) {

        return new WorkDTO(work.getStudentId(), work.getEmploymentType(), work.getCompanyName(), work.getDuration(), work.getDomain());
    }
    public static Work mapToWork(WorkDTO workdto) {

        return new Work(workdto.getStudentId(), workdto.getEmploymentType(), workdto.getCompanyName(), workdto.getDuration(), workdto.getDomain());
    }

}
