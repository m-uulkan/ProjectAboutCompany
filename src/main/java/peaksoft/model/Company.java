package peaksoft.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;
    private String nameOfCompany;
    private String locatedCountry;

    @OneToMany(cascade ={PERSIST,MERGE,REFRESH,DETACH,REMOVE} ,fetch = FetchType.EAGER,mappedBy = "company")
    private List<Course> courseList=new ArrayList<>();

    public Company() {
    }

    public Company(Long id, String nameOfCompany, String locatedCountry) {
        this.id = id;
        this.nameOfCompany = nameOfCompany;
        this.locatedCountry = locatedCountry;
    }
    public void setCourses1(Course course){
        courseList.add(course);
    }

}
