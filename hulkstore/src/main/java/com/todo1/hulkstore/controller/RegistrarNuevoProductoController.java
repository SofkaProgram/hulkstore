package com.todo1.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.service.ProductoService;

@Controller
public class RegistrarNuevoProductoController {
	@Autowired
	private ProductoService productoService;

	public void registrarNuevoProducto(ProductoDTO productoDTO) {
		try {
			
		} catch(Exception ex) {}
	}

}
