package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Company;

import javax.persistence.Transient;

@Getter
@Setter
public class RequestCourse {
    private String courseName;
    private String duration;
    private Company company;

}
