package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
