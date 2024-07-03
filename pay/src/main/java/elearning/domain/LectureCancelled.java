package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class LectureCancelled extends AbstractEvent {

    private Long id;
    private String lectureName;
    private Integer lecturePrice;
    private String status;
}
