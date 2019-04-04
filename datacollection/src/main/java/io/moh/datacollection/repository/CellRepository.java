package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.moh.datacollection.domain.entities.Cell;

public interface CellRepository extends JpaRepository<Cell, Long> {

}
