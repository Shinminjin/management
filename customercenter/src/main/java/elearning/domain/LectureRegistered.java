package elearning.domain;

import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class LectureRegistered extends AbstractEvent {

    private Long id;
    private String lectureName;
    private Integer lecturePrice;
    private Date courseStartDate;
    private Date courseEndDate;
    private String status;
}
