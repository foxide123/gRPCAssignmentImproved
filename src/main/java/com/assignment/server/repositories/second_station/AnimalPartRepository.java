package com.assignment.server.repositories.second_station;

import com.assignment.protobuf.AnimalPart;
import com.assignment.server.dao.second_station.AnimalPartDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalPartRepository extends JpaRepository<AnimalPartDao, Long> {
}
