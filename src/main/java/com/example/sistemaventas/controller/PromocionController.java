package com.example.sistemaventas.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sistemaventas.entity.Promocion;
import com.example.sistemaventas.services.PromocionService;





@Controller
@RequestMapping("/promociones")
public class PromocionController {
    @Autowired
    PromocionService promocionService;

    @GetMapping()
    public String ListPromocion(Model model) {
        model.addAttribute("promociones", promocionService.selectAll());
        return "promociones";
    } 

    @PostMapping("nuevo")
    public String newPromocion(Model model) {
        model.addAttribute("promocion", new Promocion());
        return "promociones";
    }

    @PutMapping("actualizar/{id_promocion}")
    public String updatePromocion(@PathVariable Integer id_promocion, @ModelAttribute Promocion promocion) {
        Promocion existingPromocion = promocionService.selectById(id_promocion);
        if (existingPromocion != null) {
            existingPromocion.setNombre(promocion.getNombre());
            existingPromocion.setDescripcion(promocion.getDescripcion());
            existingPromocion.setDescuento(promocion.getDescuento());
            existingPromocion.setFecha_inicio(promocion.getFecha_inicio());
            existingPromocion.setFecha_fin(promocion.getFecha_fin());
            promocionService.updatePromocion(existingPromocion);
        }
        return "redirect:/promociones";
    }

    @PostMapping("guardar")
    public String savePromocion(@ModelAttribute Promocion promocion) {
        promocionService.insertPromocion(promocion);
        return "redirect:/promociones";
    }

    @DeleteMapping("eliminar/{id_promocion}")
    public String deletePromocion(@PathVariable Integer id_promocion) {
        promocionService.deletePromocion(id_promocion);
        return "redirect:/promociones";
    }
}
