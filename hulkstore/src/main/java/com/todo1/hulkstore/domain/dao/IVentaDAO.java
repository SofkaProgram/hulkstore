package com.todo1.hulkstore.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {

}
