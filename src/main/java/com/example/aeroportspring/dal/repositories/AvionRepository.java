package com.example.aeroportspring.dal.repositories;

import com.example.aeroportspring.dal.models.Avion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionRepository extends JpaRepository<Avion, Long> {
}
