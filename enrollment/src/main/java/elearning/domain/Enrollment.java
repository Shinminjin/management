package elearning.domain;

import elearning.EnrollmentApplication;
import elearning.domain.LectureRegistered;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Enrollment_table")
@Data
//<<< DDD / Aggregate Root
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lectureName;

    private Integer lecturePrice;

    private Date courseStartDate;

    private Date courseEndDate;

    private String status;

    @PostPersist
    public void onPostPersist() {
        LectureRegistered lectureRegistered = new LectureRegistered(this);
        lectureRegistered.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static EnrollmentRepository repository() {
        EnrollmentRepository enrollmentRepository = EnrollmentApplication.applicationContext.getBean(
            EnrollmentRepository.class
        );
        return enrollmentRepository;
    }

    //<<< Clean Arch / Port Method
    public void cancelLecture() {
        //implement business logic here:

        LectureCancelled lectureCancelled = new LectureCancelled(this);
        lectureCancelled.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
