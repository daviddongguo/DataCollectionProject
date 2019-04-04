package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.moh.datacollection.domain.entities.Line;

public interface LineRepository extends JpaRepository<Line, Long> {

}
