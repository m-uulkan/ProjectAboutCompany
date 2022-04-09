package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Course;
import peaksoft.model.Group;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RequestGroup {
    private String nameGroup;
    private String dateOfStart;
    private String dateOfFinish;


}
