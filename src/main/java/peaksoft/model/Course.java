package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import peaksoft.dto.RequestGroup;
import peaksoft.dto.response.ResponseGroup;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String courseName;
    private String duration;


    @ManyToOne(cascade = {PERSIST,MERGE},fetch = FetchType.EAGER)
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH,REMOVE},fetch = FetchType.EAGER)
    @JoinTable(name="course_group",joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name="group_id"))
    //@JsonIgnore
    private List<Group> groupList=new ArrayList<>();

    @OneToOne(cascade = {REFRESH,MERGE,DETACH,PERSIST,REMOVE},fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Course() {
    }

    public Course(Long id, String courseName, String duration) {
        this.id = id;
        this.courseName = courseName;
        this.duration = duration;
    }

    public Course(Long id) {
        this.id = id;
    }
    public void addGroupToCourse(Group group){
        groupList.add(group);
    }
    public void setCompany1(Company company){
        this.company=company;
        company.setCourses1(this);
    }

}
