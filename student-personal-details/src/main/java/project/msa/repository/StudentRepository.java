package project.msa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.msa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> { }
