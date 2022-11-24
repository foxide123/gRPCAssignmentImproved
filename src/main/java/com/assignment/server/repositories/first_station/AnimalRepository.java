package com.assignment.server.repositories.first_station;

import com.assignment.server.dao.first_station.AnimalDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalDao, Long> {

}
