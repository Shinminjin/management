package elearning.infra;

import elearning.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/enrollments")
@Transactional
public class EnrollmentController {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @RequestMapping(
        value = "enrollments/{id}/cancellecture",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Enrollment cancelLecture(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /enrollment/cancelLecture  called #####");
        Optional<Enrollment> optionalEnrollment = enrollmentRepository.findById(
            id
        );

        optionalEnrollment.orElseThrow(() -> new Exception("No Entity Found"));
        Enrollment enrollment = optionalEnrollment.get();
        enrollment.cancelLecture();

        enrollmentRepository.save(enrollment);
        return enrollment;
    }
}
//>>> Clean Arch / Inbound Adaptor
