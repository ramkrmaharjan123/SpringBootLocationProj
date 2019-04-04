package com.kcing.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcing.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
