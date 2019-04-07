package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.moh.datacollection.domain.entities.Line;

@RepositoryRestResource(path = "lines")
public interface LineRepository extends JpaRepository<Line, Long> {

}
