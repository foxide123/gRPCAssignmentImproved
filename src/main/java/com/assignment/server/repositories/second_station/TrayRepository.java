package com.assignment.server.repositories.second_station;

import com.assignment.server.dao.second_station.TrayDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrayRepository extends JpaRepository<TrayDao, Long> {
}
