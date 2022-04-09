package peaksoft.mapper;
import org.springframework.stereotype.Component;
import peaksoft.dto.RequestStudent;
import peaksoft.dto.response.ResponseGroup;
import peaksoft.dto.response.ResponseStudent;
import peaksoft.model.Group;
import peaksoft.model.Student;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentMapper {


    public Student create(RequestStudent requestStudent) {
        Student student=new Student();
      student.setName(requestStudent.getName());
      student.setSurname(requestStudent.getSurname());
      student.setEmail(requestStudent.getEmail());
      student.setStudyFormat(requestStudent.getStudyFormat());
      return student;
    }


    public ResponseStudent viewStudent(Student student){
        ResponseStudent responseStudent=new ResponseStudent();
        if(student.getId() !=null){
            responseStudent.setId(String.valueOf(student.getId()));
        }
        responseStudent.setName(student.getName());
        responseStudent.setSurname(student.getSurname());
        responseStudent.setEmail(student.getEmail());
        responseStudent.setStudyFormat(student.getStudyFormat());
        return  responseStudent;
    }

    public List<ResponseStudent> viewStudents(List<Student>studentList) {
        List<ResponseStudent>responses=new ArrayList<>();
        for(Student g:studentList){
            responses.add(viewStudent(g));
        }
        return responses;
    }
    public void update(Student student,RequestStudent requestStudent){
        student.setName(requestStudent.getName());
        student.setSurname(requestStudent.getSurname());
        student.setEmail(requestStudent.getEmail());
        student.setStudyFormat(requestStudent.getStudyFormat());
    }
}




