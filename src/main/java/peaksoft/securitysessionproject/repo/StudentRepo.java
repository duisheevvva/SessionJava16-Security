package peaksoft.securitysessionproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.securitysessionproject.entities.Student;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
