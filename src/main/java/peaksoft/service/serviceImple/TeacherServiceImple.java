package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestTeacher;
import peaksoft.dto.response.ResponseTeacher;
import peaksoft.mapper.TeacherMapper;
import peaksoft.model.Teacher;
import peaksoft.repository.TeacherRepository;
import peaksoft.service.TeacherService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImple implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;


    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public ResponseTeacher updateTeacher(Long id, RequestTeacher requestTeacher) {
        Teacher teacher=teacherRepository.findById(id).get();
        teacherMapper.update(teacher,requestTeacher);
        return teacherMapper.viewTeacher(teacherRepository.save(teacher));
    }

    @Override
    public List<ResponseTeacher> getAllTeacher(List<Teacher> teachers) {
        List<Teacher>teacherList=teacherRepository.findAll();
        return teacherMapper.viewTeachers(teacherList);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public void removeTeacherById(Long id) {
     Teacher teacher=teacherRepository.findById(id).get();
     teacherRepository.deleteById(id);
     teacherMapper.viewTeacher(teacher);
    }
}
