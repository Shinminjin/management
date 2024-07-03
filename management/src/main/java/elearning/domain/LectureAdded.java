package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureAdded extends AbstractEvent {

    private Long id;
    private String lectureName;
    private String lectureMaterial;

    public LectureAdded(Management aggregate) {
        super(aggregate);
    }

    public LectureAdded() {
        super();
    }
}
//>>> DDD / Domain Event
