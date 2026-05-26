package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import java.util.List;

public interface AlumnoService {
    List<AlumnoModel> findAlumnos();
    void saveAlumno(AlumnoModel alumno);
    AlumnoModel findAlumnoById(long id);
    void deleteAlumnoById(long id);
}