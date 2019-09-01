package com.todo1.hulkstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.infraestructure.utility.JsonEntityConverter;
import com.todo1.hulkstore.infraestructure.utility.ProductoDTOConverter;
import com.todo1.hulkstore.service.IProductoService;

@Controller
public class MostrarListaProductosController {
	@Autowired
	private IProductoService productoService;

	public List<ProductoDTO> encontrarListaProductos() {
		try {
			List<Producto> listaProductos = productoService.encontrarTodosProductos();
			List<ProductoDTO> listaProducto = this.convertirProductos(listaProductos);
			return listaProducto;
		} catch(Exception ex) {
			throw ex;
		}
	}

	private List<ProductoDTO> convertirProductos(List<Producto> listaProductos) {
		List<ProductoDTO> listaProductosDTO = new ArrayList<>();
		for(Producto producto : listaProductos) {
			ProductoDTO productoConvertido = JsonEntityConverter.generarProductoDTO(producto);
			listaProductosDTO.add(productoConvertido);
		}
		return listaProductosDTO;
	}

}
