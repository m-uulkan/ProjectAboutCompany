package peaksoft.dto;

import lombok.Getter;
import lombok.Setter;
import peaksoft.model.StudyFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class RequestStudent {
    private String surname;
    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
}
