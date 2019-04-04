package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.moh.datacollection.domain.entities.ColumnProfile;

public interface ColumnRepository extends JpaRepository<ColumnProfile, Long> {

}