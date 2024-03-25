package project.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.msa.entity.Academics;

@Repository
public interface AcademicRepository extends JpaRepository<Academics,Long> {
}
