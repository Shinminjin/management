package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class LectureDeleted extends AbstractEvent {

    private Long id;
    private String lectureName;
    private String lectureMaterial;

    public LectureDeleted(Management aggregate) {
        super(aggregate);
    }

    public LectureDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
