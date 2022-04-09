package peaksoft.service;

import peaksoft.dto.RequestGroup;
import peaksoft.dto.RequestStudent;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.dto.response.ResponseStudent;
import peaksoft.model.Group;
import peaksoft.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    ResponseStudent updateStudent(Long id,RequestStudent requestStudent);
    List<ResponseStudent> getAllStudent(List<Student>students);
    Student getStudentById(Long id);
    void removeStudentById(Long id);

}
