package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureRegistered extends AbstractEvent {

    private Long id;
    private String lectureName;
    private Integer lecturePrice;
    private Date courseStartDate;
    private Date courseEndDate;
    private String status;

    public LectureRegistered(Enrollment aggregate) {
        super(aggregate);
    }

    public LectureRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
