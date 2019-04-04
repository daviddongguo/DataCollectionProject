package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.moh.datacollection.domain.entities.RowProfile;

public interface RowRepository extends JpaRepository<RowProfile, Long> {

}
