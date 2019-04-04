package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.moh.datacollection.domain.entities.Cell;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {

}
