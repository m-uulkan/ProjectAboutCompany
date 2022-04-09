package peaksoft.dto.response;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import peaksoft.model.Company;

@Getter
@Setter
public class ResponseCourse {
    @NotNull
    private String id;
    private String courseName;
    private String duration;

}
