package peaksoft.service.serviceImple;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.dto.RequestStudent;
import peaksoft.dto.response.ResponseStudent;
import peaksoft.mapper.StudentMapper;
import peaksoft.model.Student;
import peaksoft.repository.StudentRepository;
import peaksoft.service.StudentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImple implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;


    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    @Override
    public ResponseStudent updateStudent(Long id, RequestStudent requestStudent) {
        Student student=studentRepository.findById(id).get();
        studentMapper.update(student,requestStudent);
     return studentMapper.viewStudent(studentRepository.save(student));
    }

    @Override
    public List<ResponseStudent> getAllStudent(List<Student> students) {
        List<Student>studentList=studentRepository.findAll();
        return studentMapper.viewStudents(studentList);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void removeStudentById(Long id) {
        Student student=studentRepository.findById(id).get();
        studentRepository.deleteById(id);
        studentMapper.viewStudent(student);
    }
}
