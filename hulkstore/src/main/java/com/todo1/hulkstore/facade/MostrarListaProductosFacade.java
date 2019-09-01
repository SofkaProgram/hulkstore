package com.todo1.hulkstore.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.todo1.hulkstore.controller.MostrarListaProductosController;
import com.todo1.hulkstore.domain.dto.ProductoDTO;

@Controller
public class MostrarListaProductosFacade {
	@Autowired
	private MostrarListaProductosController listaProductosController;
	
	@RequestMapping(value = "/api/producto/listaproductos", method = RequestMethod.GET)
	public String mostrarPaginaCrearVenta(WebRequest request, Model model) {
		List<ProductoDTO> productos = listaProductosController.encontrarListaProductos();
		model.addAttribute("productos", productos);
		return "listaProductos";
	}
}
