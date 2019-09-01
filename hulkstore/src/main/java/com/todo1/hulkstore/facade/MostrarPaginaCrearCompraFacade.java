package com.todo1.hulkstore.facade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.todo1.hulkstore.view.dto.CrearCompraDTO;

@Controller
public class MostrarPaginaCrearCompraFacade {

	@RequestMapping(value = "/api/compra/pagina/crear", method = RequestMethod.GET)
	public String mostrarPaginaCrearVenta(WebRequest request, Model model) {
		CrearCompraDTO crearCompra = new CrearCompraDTO();
		model.addAttribute("crearCompra", crearCompra);
		return "crearCompra";
	}
}
