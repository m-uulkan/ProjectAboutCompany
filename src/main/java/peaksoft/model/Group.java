package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @SequenceGenerator(
            name = "group_sequence",
            sequenceName = "group_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "group_sequence"
    )
    private Long id;
    private String nameGroup;
    private String dateOfStart;
    private String dateOfFinish;


    @ManyToMany(cascade = {PERSIST,DETACH,REFRESH,MERGE},fetch = FetchType.EAGER,mappedBy = "groupList")
    @JsonIgnore
    private List<Course> courseList=new ArrayList<>();

    @OneToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "group")
    private List<Student>studentList=new ArrayList<>();
    public Group() {
    }

    public Group(Long id, String nameGroup, String dateOfStart, String dateOfFinish) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    public  void addCourseToGroup(Course course){
        courseList.add(course);
        course.addGroupToCourse(this);
    }

  public void setStudentToGroup(Student student){
        studentList.add(student);
    }
}
