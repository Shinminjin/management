package elearning.infra;

import elearning.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Enrollment>> {

    @Override
    public EntityModel<Enrollment> process(EntityModel<Enrollment> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/cancellecture")
                .withRel("cancellecture")
        );

        return model;
    }
}
