package com.todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.LineaVenta;
import com.todo1.hulkstore.domain.dao.ILineaVentaDAO;

@Service
public class LineaVentaService implements ILineaVentaService {
	@Autowired
	private ILineaVentaDAO lineaVentaDAO;
	
	@Override
	public void crearLineaVenta(LineaVenta lineaVenta) {
		try {
			lineaVentaDAO.save(lineaVenta);
		} catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public void actualizarLineaVenta(LineaVenta lineaVenta) {
		try {
			lineaVentaDAO.save(lineaVenta);
		} catch(Exception ex) {
			throw ex;
		}
	}

}
