package elearning.infra;

import elearning.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ManagementHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Management>> {

    @Override
    public EntityModel<Management> process(EntityModel<Management> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/updatelecture")
                .withRel("updatelecture")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/deletelecture")
                .withRel("deletelecture")
        );

        return model;
    }
}
