package com.todo1.hulkstore.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo1.hulkstore.domain.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer> {
	
}
