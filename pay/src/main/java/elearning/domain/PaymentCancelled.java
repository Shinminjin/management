package elearning.domain;

import elearning.domain.*;
import elearning.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
    private Long enrollmentId;
    private String lectureName;
    private Integer price;
    private String status;

    public PaymentCancelled(Pay aggregate) {
        super(aggregate);
    }

    public PaymentCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
