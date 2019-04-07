package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.moh.datacollection.domain.entities.RowProfile;

@RepositoryRestResource(path = "rows")
public interface RowRepository extends JpaRepository<RowProfile, Long> {

}
