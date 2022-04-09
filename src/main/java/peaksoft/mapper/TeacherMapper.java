package peaksoft.mapper;

import org.springframework.stereotype.Component;
import peaksoft.dto.RequestTeacher;
import peaksoft.dto.response.ResponseTeacher;
import peaksoft.model.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component

public class TeacherMapper {

    public Teacher create(RequestTeacher requestTeacher){
        Teacher teacher=new Teacher();
        teacher.setName(requestTeacher.getName());
        teacher.setSurname(requestTeacher.getSurname());
        teacher.setEmail(requestTeacher.getEmail());
        return teacher;
    }
    public void update(Teacher teacher,RequestTeacher requestTeacher){
        teacher.setName(requestTeacher.getName());
        teacher.setSurname(requestTeacher.getSurname());
        teacher.setEmail(requestTeacher.getEmail());
    }

    public ResponseTeacher viewTeacher(Teacher teacher){
        ResponseTeacher responseTeacher=new ResponseTeacher();
        if(teacher.getId()!=null){
            responseTeacher.setId(String.valueOf(teacher.getId()));
        }
        responseTeacher.setName(teacher.getName());
        responseTeacher.setSurname(teacher.getSurname());
        responseTeacher.setEmail(teacher.getEmail());
        return responseTeacher;
    }
    public List<ResponseTeacher>viewTeachers(List<Teacher>teachers){
        List<ResponseTeacher>responseTeachers=new ArrayList<>();
        for (Teacher t:
             teachers) {
            responseTeachers.add(viewTeacher(t));
        }
        return responseTeachers;
    }
}
