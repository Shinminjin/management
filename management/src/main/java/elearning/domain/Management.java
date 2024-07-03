package elearning.domain;

import elearning.ManagementApplication;
import elearning.domain.LectureAdded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Management_table")
@Data
//<<< DDD / Aggregate Root
public class Management {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String lectureName;

    private String lectureMaterial;

    @PostPersist
    public void onPostPersist() {
        LectureAdded lectureAdded = new LectureAdded(this);
        lectureAdded.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static ManagementRepository repository() {
        ManagementRepository managementRepository = ManagementApplication.applicationContext.getBean(
            ManagementRepository.class
        );
        return managementRepository;
    }

    //<<< Clean Arch / Port Method
    public void updateLecture(UpdateLectureCommand updateLectureCommand) {
        //implement business logic here:

        LectureUpdated lectureUpdated = new LectureUpdated(this);
        lectureUpdated.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void deleteLecture() {
        //implement business logic here:

        LectureDeleted lectureDeleted = new LectureDeleted(this);
        lectureDeleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
