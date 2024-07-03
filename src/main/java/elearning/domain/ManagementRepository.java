package elearning.domain;

import elearning.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "managements",
    path = "managements"
)
public interface ManagementRepository
    extends PagingAndSortingRepository<Management, Long> {}
