package com.todo1.hulkstore.service;

import java.util.List;

import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.dto.ProductoDTO;


public interface IProductoService {

	Producto encontrarProducto(ProductoDTO nuevoProducto);

	List<Producto> encontrarTodosProductos();

}
