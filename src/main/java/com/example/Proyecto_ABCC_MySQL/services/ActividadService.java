package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.ActividadModel;
import java.util.List;
import java.util.Optional;

public interface ActividadService {
    List<ActividadModel> listarActividades();
    void guardarActividad(ActividadModel actividad);
    Optional<ActividadModel> buscarActividad(Long id);
    void eliminarActividad(Long id);
}