package com.todo1.hulkstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.dao.IProductoDAO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;


@Service
public class ProductoService implements IProductoService {
	@Autowired
	private IProductoDAO productoDAO;

	@Override
	public Producto encontrarProducto(ProductoDTO nuevoProducto) {
		try {
			Optional<Producto> productoEncontrado = productoDAO.findById(nuevoProducto.getId());
			Producto productoDevolver = productoEncontrado.get();
			return productoDevolver;
		} catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public List<Producto> encontrarTodosProductos() {
		try {
			List<Producto> listaProductos = productoDAO.findAll();
			return listaProductos;
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
