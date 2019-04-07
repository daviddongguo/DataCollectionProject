package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import io.moh.datacollection.domain.entities.Cell;

@RepositoryRestResource(path = "cells")
public interface CellRepository extends JpaRepository<Cell, Long> {

}
