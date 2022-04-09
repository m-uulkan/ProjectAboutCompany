package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.RequestCompany;
import peaksoft.dto.RequestCourse;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.dto.response.ResponseCourse;
import peaksoft.model.Company;
import peaksoft.model.Course;
import peaksoft.service.serviceImple.CompanyServiceImple;
import peaksoft.service.serviceImple.CourseServiceImple;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses/{id}")
public class CourseApi {

    private final CompanyServiceImple companyService;
    private final CourseServiceImple courseService;


    @PostMapping
    public ResponseCourse saveCourse(@RequestBody RequestCourse courseRequest,@PathVariable("id") Long id) {
        courseRequest.setCompany(companyService.getCompanyById(id));
        return courseService.saveCourse(courseRequest);
    }

    @GetMapping("/get/{id2}")
    public Course getCourseByID1(@PathVariable ("id2") Long id){
       return courseService.getCourseById(id);
    }

    @PutMapping("/update/{id2}")
    public ResponseCourse update(@PathVariable("id2") Long id, @RequestBody RequestCourse courseRequest) {
        return courseService.updateCompany(id, courseRequest);
    }

    @DeleteMapping("/remove/{id2}")
    public void deleteCourseById(@PathVariable ("id2") Long id) {
        courseService.removeCourseById(id);
    }

    @GetMapping("/all")
    public List<ResponseCourse> getCourses(@RequestBody List<Course> courses){
        return courseService.getAllCourses(courses);
    }
}
