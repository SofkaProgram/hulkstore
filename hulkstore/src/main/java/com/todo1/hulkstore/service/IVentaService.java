package com.todo1.hulkstore.service;

import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.Venta;
import com.todo1.hulkstore.domain.dto.VentaDTO;


public interface IVentaService {
	public void crearVenta(Venta venta);
}
