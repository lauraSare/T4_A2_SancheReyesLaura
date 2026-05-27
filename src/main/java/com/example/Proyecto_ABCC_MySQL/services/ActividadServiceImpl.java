package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.ActividadModel;
import com.example.Proyecto_ABCC_MySQL.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public List<ActividadModel> listarActividades() {
        return actividadRepository.findAll();
    }

    @Override
    public void guardarActividad(ActividadModel actividad) {
        actividadRepository.save(actividad);
    }

    @Override
    public Optional<ActividadModel> buscarActividad(Long id) {
        return actividadRepository.findById(id);
    }

    @Override
    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}