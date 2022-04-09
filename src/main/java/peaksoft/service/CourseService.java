package peaksoft.service;

import peaksoft.dto.RequestCompany;
import peaksoft.dto.RequestCourse;
import peaksoft.dto.response.ResponseCompany;
import peaksoft.dto.response.ResponseCourse;
import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CourseService {
    ResponseCourse saveCourse(RequestCourse requestCourse);
    ResponseCourse updateCompany(Long id,RequestCourse course);
    List<ResponseCourse> getAllCourses(List<Course>courses);
    Course getCourseById(Long id);
    void removeCourseById(Long id);
}
