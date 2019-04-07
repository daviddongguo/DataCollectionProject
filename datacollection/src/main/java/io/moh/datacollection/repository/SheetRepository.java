package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.moh.datacollection.domain.entities.Sheet;

@RepositoryRestResource(path = "sheets")
public interface SheetRepository extends JpaRepository<Sheet, Long> {

}
