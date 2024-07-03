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
// @RequestMapping(value="/managements")
@Transactional
public class ManagementController {

    @Autowired
    ManagementRepository managementRepository;

    @RequestMapping(
        value = "managements/{id}/updatelecture",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Management updateLecture(
        @PathVariable(value = "id") Long id,
        @RequestBody UpdateLectureCommand updateLectureCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /management/updateLecture  called #####");
        Optional<Management> optionalManagement = managementRepository.findById(
            id
        );

        optionalManagement.orElseThrow(() -> new Exception("No Entity Found"));
        Management management = optionalManagement.get();
        management.updateLecture(updateLectureCommand);

        managementRepository.save(management);
        return management;
    }

    @RequestMapping(
        value = "managements/{id}/deletelecture",
        method = RequestMethod.DELETE,
        produces = "application/json;charset=UTF-8"
    )
    public Management deleteLecture(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /management/deleteLecture  called #####");
        Optional<Management> optionalManagement = managementRepository.findById(
            id
        );

        optionalManagement.orElseThrow(() -> new Exception("No Entity Found"));
        Management management = optionalManagement.get();
        management.deleteLecture();

        managementRepository.delete(management);
        return management;
    }
}
//>>> Clean Arch / Inbound Adaptor
