package com.assignment.server.repositories.second_station;

import com.assignment.server.dao.second_station.AnimalPartDao;
import com.assignment.server.dao.second_station.TrayDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrayRepository extends JpaRepository<TrayDao, Long> {

}
