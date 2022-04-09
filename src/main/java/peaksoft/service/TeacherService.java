package peaksoft.service;

import peaksoft.dto.RequestStudent;
import peaksoft.dto.RequestTeacher;
import peaksoft.dto.response.ResponseStudent;
import peaksoft.dto.response.ResponseTeacher;
import peaksoft.model.Student;
import peaksoft.model.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher saveTeacher(Teacher teacher);
    ResponseTeacher updateTeacher(Long id, RequestTeacher requestTeacher);
    List<ResponseTeacher> getAllTeacher(List<Teacher>teachers);
    Teacher getTeacherById(Long id);
    void removeTeacherById(Long id);
}
