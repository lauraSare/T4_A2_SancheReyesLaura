package com.example.Proyecto_ABCC_MySQL.controllers;

import com.example.Proyecto_ABCC_MySQL.models.ActividadModel;
import com.example.Proyecto_ABCC_MySQL.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("actividades", actividadService.listarActividades());
        return "actividades/listaActividades";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("actividad", new ActividadModel());
        return "actividades/nuevaActividad";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ActividadModel actividad) {
        actividadService.guardarActividad(actividad);
        return "redirect:/actividades";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        actividadService.buscarActividad(id).ifPresent(a -> model.addAttribute("actividad", a));
        return "actividades/editarActividad";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute ActividadModel actividad) {
        actividad.setId(id);
        actividadService.guardarActividad(actividad);
        return "redirect:/actividades";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
        return "redirect:/actividades";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        actividadService.buscarActividad(id).ifPresent(a -> model.addAttribute("actividad", a));
        return "actividades/verActividad";
    }
}