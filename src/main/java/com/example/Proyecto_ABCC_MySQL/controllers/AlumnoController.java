package com.example.Proyecto_ABCC_MySQL.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.Proyecto_ABCC_MySQL.services.AlumnoService;
import com.example.Proyecto_ABCC_MySQL.models.AlumnoModel;
import java.util.List;

@Controller
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Ver lista
    @GetMapping("/")
    public String listaAlumnos(Model model) {
        List<AlumnoModel> listaAlumnos = alumnoService.findAlumnos();
        model.addAttribute("alumnos", listaAlumnos);
        return "index";
    }

    // Mostrar formulario nuevo alumno
    @GetMapping("/nuevoAlumno")
    public String nuevoAlumnoForm(Model model) {
        AlumnoModel alumno = new AlumnoModel();
        model.addAttribute("alumno", alumno);
        return "nuevoAlumno";
    }

    // Guardar nuevo alumno
    @PostMapping("/guardarAlumno")
    public String guardarAlumno(@ModelAttribute("alumno") AlumnoModel alumno) {
        alumnoService.saveAlumno(alumno);
        return "redirect:/";
    }

    // Mostrar formulario editar
    @GetMapping("/editar/{id}")
    public String editarAlumnoForm(@PathVariable(value = "id") long id, Model model) {
        AlumnoModel alumno = alumnoService.findAlumnoById(id);
        model.addAttribute("alumno", alumno);
        return "editarAlumno";
    }

    // Guardar edición
    @PostMapping("/actualizarAlumno")
    public String actualizarAlumno(@ModelAttribute("alumno") AlumnoModel alumno) {
        alumnoService.saveAlumno(alumno);
        return "redirect:/";
    }

    // Ver detalle
    @GetMapping("/ver/{id}")
    public String verAlumno(@PathVariable(value = "id") long id, Model model) {
        AlumnoModel alumno = alumnoService.findAlumnoById(id);
        model.addAttribute("alumno", alumno);
        return "verAlumno";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable(value = "id") long id) {
        alumnoService.deleteAlumnoById(id);
        return "redirect:/";
    }
}