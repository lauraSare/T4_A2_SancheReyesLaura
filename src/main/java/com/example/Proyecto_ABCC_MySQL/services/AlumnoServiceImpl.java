package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import com.example.Proyecto_ABCC_MySQL.repositories.AlumnoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<AlumnoModel> findAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public void saveAlumno(AlumnoModel alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public AlumnoModel findAlumnoById(long id) {
        Optional<AlumnoModel> optional = alumnoRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Alumno no encontrado con id: " + id);
        }
    }

    @Override
    public void deleteAlumnoById(long id) {
        alumnoRepository.deleteById(id);
    }
}