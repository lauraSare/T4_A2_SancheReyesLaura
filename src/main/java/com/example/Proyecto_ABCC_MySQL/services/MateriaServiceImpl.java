package com.example.Proyecto_ABCC_MySQL.services;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import com.example.Proyecto_ABCC_MySQL.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public List<MateriaModel> listarMaterias() {
        return materiaRepository.findAll();
    }

    @Override
    public void guardarMateria(MateriaModel materia) {
        materiaRepository.save(materia);
    }

    @Override
    public Optional<MateriaModel> buscarMateria(Long id) {
        return materiaRepository.findById(id);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepository.deleteById(id);
    }
}