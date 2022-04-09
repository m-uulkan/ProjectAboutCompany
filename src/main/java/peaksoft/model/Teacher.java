package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long id;
    private String name;
    private String surname;
    private String email;

    @OneToOne(cascade = {REFRESH,MERGE,DETACH,PERSIST},fetch = FetchType.LAZY,mappedBy = "teacher")
    @JsonIgnore
    private Course course;

    public Teacher() {
    }

    public Teacher(Long id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    public void setCourse1(Course course) {
        this.course = course;
        course.setTeacher(this);
    }
}
