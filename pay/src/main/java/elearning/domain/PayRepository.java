package elearning.domain;

import elearning.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "pays", path = "pays")
public interface PayRepository extends PagingAndSortingRepository<Pay, Long> {}
