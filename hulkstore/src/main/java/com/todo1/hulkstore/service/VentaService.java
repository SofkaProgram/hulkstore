package com.todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.Venta;
import com.todo1.hulkstore.domain.dao.IVentaDAO;

@Service
public class VentaService implements IVentaService {
	@Autowired
	private IVentaDAO ventaDAO;

	@Override
	public void crearVenta(Venta venta) {
		try {
			ventaDAO.save(venta);
		} catch(Exception ex) {
			throw ex;
		}
	}

}
