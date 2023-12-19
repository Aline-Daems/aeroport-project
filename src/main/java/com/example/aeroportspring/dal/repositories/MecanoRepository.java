package com.example.aeroportspring.dal.repositories;

import com.example.aeroportspring.dal.models.Mecano;
import com.example.aeroportspring.dal.models.TypeAvion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface MecanoRepository extends JpaRepository<Mecano, Long> {

    @Query("SELECT m.typeAvion FROM Mecano m WHERE m.id = :mecanoId")
    Boolean findTypesAvionByMecanoId(@Param("mecanoId") Long mecanoId);
}
