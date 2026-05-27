package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import java.util.List;
import java.util.Optional;

public interface MateriaService {
    List<MateriaModel> listarMaterias();
    void guardarMateria(MateriaModel materia);
    Optional<MateriaModel> buscarMateria(Long id);
    void eliminarMateria(Long id);
}