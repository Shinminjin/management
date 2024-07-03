package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureCancelled extends AbstractEvent {

    private Long id;
    private String lectureName;
    private Integer lecturePrice;
    private String status;

    public LectureCancelled(Enrollment aggregate) {
        super(aggregate);
    }

    public LectureCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
