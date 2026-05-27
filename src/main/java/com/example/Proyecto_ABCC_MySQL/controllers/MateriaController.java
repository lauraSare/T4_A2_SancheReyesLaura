package com.example.Proyecto_ABCC_MySQL.controllers;

import com.example.Proyecto_ABCC_MySQL.models.MateriaModel;
import com.example.Proyecto_ABCC_MySQL.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("materias", materiaService.listarMaterias());
        return "materias/listaMaterias";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("materia", new MateriaModel());
        return "materias/nuevaMateria";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute MateriaModel materia) {
        materiaService.guardarMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        materiaService.buscarMateria(id).ifPresent(m -> model.addAttribute("materia", m));
        return "materias/editarMateria";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute MateriaModel materia) {
        materia.setId(id);
        materiaService.guardarMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        materiaService.eliminarMateria(id);
        return "redirect:/materias";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        materiaService.buscarMateria(id).ifPresent(m -> model.addAttribute("materia", m));
        return "materias/verMateria";
    }
}