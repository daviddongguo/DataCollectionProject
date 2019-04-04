package io.moh.datacollection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.moh.datacollection.domain.entities.RowProfile;

@Repository
public interface RowRepository extends JpaRepository<RowProfile, Long> {

}
