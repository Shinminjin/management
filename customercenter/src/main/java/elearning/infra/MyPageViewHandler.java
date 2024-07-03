package elearning.infra;

import elearning.config.kafka.KafkaProcessor;
import elearning.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyPageViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private MyPageRepository myPageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLectureRegistered_then_CREATE_1(
        @Payload LectureRegistered lectureRegistered
    ) {
        try {
            if (!lectureRegistered.validate()) return;

            // view 객체 생성
            MyPage myPage = new MyPage();
            // view 객체에 이벤트의 Value 를 set 함
            myPage.setLectureName(lectureRegistered.getLectureName());
            myPage.setCourseStartDate(
                String.valueOf(lectureRegistered.getCourseStartDate())
            );
            myPage.setCourseEndDate(
                String.valueOf(lectureRegistered.getCourseEndDate())
            );
            myPage.setStatus(lectureRegistered.getStatus());
            myPage.setEnrollmentId(lectureRegistered.getId());
            // view 레파지 토리에 save
            myPageRepository.save(myPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLectureCancelled_then_UPDATE_1(
        @Payload LectureCancelled lectureCancelled
    ) {
        try {
            if (!lectureCancelled.validate()) return;
            // view 객체 조회

            List<MyPage> myPageList = myPageRepository.findByEnrollmentId(
                lectureCancelled.getId()
            );
            for (MyPage myPage : myPageList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                myPage.setStatus(lectureCancelled.getStatus());
                // view 레파지 토리에 save
                myPageRepository.save(myPage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
