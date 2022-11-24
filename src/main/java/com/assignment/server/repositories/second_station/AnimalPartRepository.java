package com.assignment.server.repositories.second_station;

import com.assignment.protobuf.AnimalPart;
import com.assignment.server.dao.second_station.AnimalPartDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalPartRepository extends JpaRepository<AnimalPartDao, Long> {
   // @Query("SELECT p FROM AnimalPartDao p WHERE p.regNr IN (:references)")
    //List<AnimalPartDao> findAllByReference(@Param("references") List<Long> references);

    @Query(nativeQuery =true,value = "SELECT * FROM animal_part as p WHERE p.reg_nr IN (:references)")   // 3. Spring JPA In cause using native query
    List<AnimalPartDao> findAllByReference(@Param("references") List<Long> references);

    @Query(value = "select * from animal_part p where p.animal_ref IN (:id)", nativeQuery = true)
    List<AnimalPartDao> findByAnimalReference(@Param("id") Long id);
}
