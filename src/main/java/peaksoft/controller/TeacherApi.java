package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestTeacher;
import peaksoft.dto.response.ResponseTeacher;
import peaksoft.model.Teacher;
import peaksoft.service.CourseService;
import peaksoft.service.serviceImple.TeacherServiceImple;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/teachers/{id}")

public class TeacherApi {

    private final TeacherServiceImple teacherService;
    private final CourseService courseService;

    @PostMapping
    public Teacher saveStudents(@RequestBody Teacher teacher, @PathVariable("id") Long id) {
        teacher.setCourse1(courseService.getCourseById(id));
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("/get/{id1}")
    public Teacher getTeacherByID1(@PathVariable("id1") Long id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/update/{id1}")
    public ResponseTeacher update(@PathVariable("id1") Long id, @RequestBody RequestTeacher teacherRequest) {
        return teacherService.updateTeacher(id, teacherRequest);
    }

    @DeleteMapping("/remove/{id1}")
    public void deleteTeacherById(@PathVariable("id1") Long id) {
        teacherService.removeTeacherById(id);
    }

    @GetMapping("/all")
    public List<ResponseTeacher> getTeachers(@RequestBody List<Teacher>teachers) {
        return teacherService.getAllTeacher(teachers);
    }
}
