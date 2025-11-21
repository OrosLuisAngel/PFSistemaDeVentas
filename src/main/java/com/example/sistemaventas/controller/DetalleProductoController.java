package com.example.sistemaventas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sistemaventas.entity.DetalleProducto;
import com.example.sistemaventas.services.DetalleProductoService;
import com.example.sistemaventas.services.ProductoService;
import com.example.sistemaventas.services.PromocionService;
import com.example.sistemaventas.services.UsuarioService;
import com.example.sistemaventas.services.VentaService;


@Controller
@RequestMapping("/detalle-productos")
public class DetalleProductoController {

    @Autowired
    private DetalleProductoService detalleProductoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private PromocionService promocionService;

    @GetMapping
    public String selectAll(Model model) {
        model.addAttribute("detalles", detalleProductoService.selectAll());
        model.addAttribute("usuarios", usuarioService.selectAll());
        model.addAttribute("productos", productoService.selectAll());
        model.addAttribute("ventas", ventaService.selectAll());
        model.addAttribute("promociones", promocionService.selectAll());
        return "detalle-productos";
    }

    @PostMapping("/guardar")
    public String saveDetalleProducto(@ModelAttribute DetalleProducto detalleProducto,
                                    @RequestParam Integer id_usuario,
                                    @RequestParam Integer id_producto,
                                    @RequestParam Integer id_venta,
                                    @RequestParam Integer id_promocion) {
        if (detalleProducto.getFecha_compra() == null || detalleProducto.getFecha_compra().isEmpty()) {
            throw new IllegalArgumentException("La fecha de compra no puede estar vacía");
        }

        detalleProducto.setUsuario(usuarioService.selectById(id_usuario));
        detalleProducto.setProducto(productoService.selectById(id_producto));
        detalleProducto.setVenta(ventaService.selectById(id_venta));
        detalleProducto.setPromocion(promocionService.selectById(id_promocion));
        detalleProductoService.insertDetalleProducto(detalleProducto);
        return "redirect:/detalle-productos";
    }

    @PutMapping("/actualizar/{id_detalle_producto}")
    public String updateDetalleProducto(@PathVariable Integer id_detalle_producto,
                                        @ModelAttribute DetalleProducto detalleProducto,
                                        @RequestParam Integer id_usuario,
                                        @RequestParam Integer id_producto,
                                        @RequestParam Integer id_venta,
                                        @RequestParam Integer id_promocion) {
        DetalleProducto existingDetalle = detalleProductoService.selectById(id_detalle_producto);
        if (existingDetalle != null) {
            existingDetalle.setUsuario(usuarioService.selectById(id_usuario));
            existingDetalle.setProducto(productoService.selectById(id_producto));
            existingDetalle.setVenta(ventaService.selectById(id_venta));
            existingDetalle.setPromocion(promocionService.selectById(id_promocion));
            existingDetalle.setCantidad(detalleProducto.getCantidad());
            existingDetalle.setPrecio(detalleProducto.getPrecio());
            existingDetalle.setFecha_compra(detalleProducto.getFecha_compra());
            detalleProductoService.updateDetalleProducto(existingDetalle);
        }
        return "redirect:/detalle-productos";
    }

    @DeleteMapping("/eliminar/{id_detalle_producto}")
    public String deleteDetalleProducto(@PathVariable Integer id_detalle_producto) {
        detalleProductoService.deleteDetalleProducto(id_detalle_producto);
        return "redirect:/detalle-productos";
    }
}
