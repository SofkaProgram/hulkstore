package com.todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.LineaCompra;
import com.todo1.hulkstore.domain.dao.ILineaCompraDAO;

@Service
public class LineaCompraService implements ILineaCompraService {
	@Autowired
	private ILineaCompraDAO lineaCompraDAO;
	
	@Override
	public void actualizarLineaCompra(LineaCompra lineaCompra) {
		try {
			lineaCompraDAO.save(lineaCompra);
		} catch(Exception ex) {
			throw ex;
		}
	}

	@Override
	public void crearLineaCompra(LineaCompra lineaCompra) {
		try {
			lineaCompraDAO.save(lineaCompra);
		} catch(Exception ex) {
			throw ex;
		}
	}

}
