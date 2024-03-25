package project.msa.studentworkdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.msa.studentworkdetails.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {
}
