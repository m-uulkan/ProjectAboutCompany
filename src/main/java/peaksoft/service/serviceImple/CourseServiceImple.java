package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestCourse;
import peaksoft.dto.response.ResponseCourse;
import peaksoft.mapper.CourseMapper;
import peaksoft.model.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.service.CourseService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImple implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public ResponseCourse saveCourse(RequestCourse requestCourse) {
        return courseMapper.viewCourse(courseRepository.save(courseMapper.create(requestCourse)));
    }

    @Override
    public ResponseCourse updateCompany(Long id, RequestCourse course) {
       Course course1=courseRepository.findById(id).get();
       courseMapper.update(course1,course);
       return courseMapper.viewCourse(courseRepository.save(course1));
    }

    @Override
    public List<ResponseCourse> getAllCourses(List<Course> courses) {
        List<Course>courseList=courseRepository.findAll();
        return courseMapper.viewCourses(courseList);
    }

    @Override
    public Course getCourseById(Long id) {
         return courseRepository.findById(id).get();
    }

    @Override
    public void removeCourseById(Long id) {
        Course course=courseRepository.findById(id).get();
        courseRepository.deleteById(id);
        courseMapper.viewCourse(course);
    }
}
