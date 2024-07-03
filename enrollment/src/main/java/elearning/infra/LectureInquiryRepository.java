package elearning.infra;

import elearning.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "lectureInquiries",
    path = "lectureInquiries"
)
public interface LectureInquiryRepository
    extends PagingAndSortingRepository<LectureInquiry, Long> {}
