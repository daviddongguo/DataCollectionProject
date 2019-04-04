package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.moh.datacollection.domain.entities.Sheet;

public interface SheetRepository extends JpaRepository<Sheet, Long> {

}
