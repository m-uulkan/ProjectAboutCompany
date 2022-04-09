package peaksoft.mapper;

import org.springframework.stereotype.Component;

import peaksoft.dto.RequestCourse;

import peaksoft.dto.response.ResponseCompany;
import peaksoft.dto.response.ResponseCourse;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.ArrayList;
import java.util.List;

@Component

public class CourseMapper {

    public Course create(RequestCourse requestCourse) {
        Course course = new Course();
        course.setCourseName(requestCourse.getCourseName());
        course.setDuration(requestCourse.getDuration());
        course.setCompany(requestCourse.getCompany());
        return course;
    }
    public ResponseCourse viewCourse(Course course){
        if(course==null){
            return null;
        }
        ResponseCourse courseResponse=new ResponseCourse();
        if(course.getId() !=null){
            courseResponse.setId(String.valueOf(course.getId()));
        }
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;
    }

    public List<ResponseCourse> viewCourses(List<Course> courseList) {
        List<ResponseCourse>responses=new ArrayList<>();
        for(Course c:courseList){
            responses.add(viewCourse(c));
        }
        return responses;
    }

    public void update(Course course1, RequestCourse course) {
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
    }
}
