package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.moh.datacollection.domain.entities.ColumnProfile;

@RepositoryRestResource(path = "columns")
public interface ColumnRepository extends JpaRepository<ColumnProfile, Long> {

}