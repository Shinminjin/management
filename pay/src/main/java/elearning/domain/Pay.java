package elearning.domain;

import elearning.PayApplication;
import elearning.domain.PaymentApproved;
import elearning.domain.PaymentCancelled;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Pay_table")
@Data
//<<< DDD / Aggregate Root
public class Pay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long enrollmentId;

    private String lectureName;

    private Integer price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        PaymentApproved paymentApproved = new PaymentApproved(this);
        paymentApproved.publishAfterCommit();

        PaymentCancelled paymentCancelled = new PaymentCancelled(this);
        paymentCancelled.publishAfterCommit();
    }

    public static PayRepository repository() {
        PayRepository payRepository = PayApplication.applicationContext.getBean(
            PayRepository.class
        );
        return payRepository;
    }

    //<<< Clean Arch / Port Method
    public static void pay(LectureRegistered lectureRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        PaymentApproved paymentApproved = new PaymentApproved(pay);
        paymentApproved.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(lectureRegistered.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);

            PaymentApproved paymentApproved = new PaymentApproved(pay);
            paymentApproved.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void cancelPayment(LectureCancelled lectureCancelled) {
        //implement business logic here:

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        PaymentCancelled paymentCancelled = new PaymentCancelled(pay);
        paymentCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(lectureCancelled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);

            PaymentCancelled paymentCancelled = new PaymentCancelled(pay);
            paymentCancelled.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
