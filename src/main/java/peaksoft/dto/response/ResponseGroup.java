package peaksoft.dto.response;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ResponseGroup {
    private String id;
    private String nameGroup;
    private String dateOfStart;
    private String dateOfFinish;
}
