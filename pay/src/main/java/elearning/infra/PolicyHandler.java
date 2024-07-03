package elearning.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import elearning.config.kafka.KafkaProcessor;
import elearning.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LectureRegistered'"
    )
    public void wheneverLectureRegistered_Pay(
        @Payload LectureRegistered lectureRegistered
    ) {
        LectureRegistered event = lectureRegistered;
        System.out.println(
            "\n\n##### listener Pay : " + lectureRegistered + "\n\n"
        );

        // Sample Logic //
        Pay.pay(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='LectureCancelled'"
    )
    public void wheneverLectureCancelled_CancelPayment(
        @Payload LectureCancelled lectureCancelled
    ) {
        LectureCancelled event = lectureCancelled;
        System.out.println(
            "\n\n##### listener CancelPayment : " + lectureCancelled + "\n\n"
        );

        // Sample Logic //
        Pay.cancelPayment(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
