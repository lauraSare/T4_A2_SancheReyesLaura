package com.example.Proyecto_ABCC_MySQL.repositories;

import com.example.Proyecto_ABCC_MySQL.models.ActividadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadModel, Long> {
}