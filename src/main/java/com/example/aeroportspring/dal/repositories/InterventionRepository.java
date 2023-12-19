package com.example.aeroportspring.dal.repositories;

import com.example.aeroportspring.dal.models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}
