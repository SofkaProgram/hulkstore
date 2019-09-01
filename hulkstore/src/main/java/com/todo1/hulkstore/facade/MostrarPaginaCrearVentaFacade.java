package com.todo1.hulkstore.facade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.todo1.hulkstore.view.dto.CrearVentaDTO;

@Controller
public class MostrarPaginaCrearVentaFacade {

	@RequestMapping(value = "/api/venta/pagina/crear", method = RequestMethod.GET)
	public String mostrarPaginaCrearVenta(WebRequest request, Model model) {
		CrearVentaDTO crearVenta = new CrearVentaDTO();
		model.addAttribute("crearVenta", crearVenta);
		return "crearVenta";
	}
}
