package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureUpdated extends AbstractEvent {

    private Long id;
    private String lectureName;
    private String lectureMaterial;

    public LectureUpdated(Management aggregate) {
        super(aggregate);
    }

    public LectureUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
