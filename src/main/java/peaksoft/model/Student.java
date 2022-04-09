package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;


@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String surname;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {PERSIST,MERGE,REFRESH,DETACH},fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    @JsonIgnore
    private Group group;

    public Student() {
    }
    public Student(Long id, String surname, String name, String email, StudyFormat studyFormat) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.studyFormat = studyFormat;
    }
    public void setGroup1(Group group){
        this.group=group;
        group.setStudentToGroup(this);
    }
}
