package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestStudent;
import peaksoft.dto.response.ResponseStudent;
import peaksoft.model.Student;
import peaksoft.service.serviceImple.GroupServiceImple;
import peaksoft.service.serviceImple.StudentServiceImple;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students/{id}")
public class StudentApi {

    private final StudentServiceImple studentService;
    private final GroupServiceImple groupService;

    @PostMapping
    public Student saveStudents(@RequestBody Student student, @PathVariable("id") Long id) {
        student.setGroup1(groupService.getGroupById(id));
        return studentService.saveStudent(student);
    }
    @GetMapping("/get/{id1}")
    public Student getStudentByID(@PathVariable("id1") Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id1}")
    public ResponseStudent update(@PathVariable("id1") Long id, @RequestBody RequestStudent studentRequest) {
        return studentService.updateStudent(id, studentRequest);
    }

    @DeleteMapping("/remove/{id1}")
    public void deleteStudentById(@PathVariable("id1") Long id) {
        studentService.removeStudentById(id);
    }

    @GetMapping("/all")
    public List<ResponseStudent> getStudents(@RequestBody List<Student>students) {
        return studentService.getAllStudent(students);
    }

}
