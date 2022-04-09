package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import peaksoft.model.Course;


public interface CourseRepository extends JpaRepository<Course,Long> {

}
