package com.todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.Compra;
import com.todo1.hulkstore.domain.dao.ICompraDAO;

@Service
public class CompraService implements ICompraService {
	@Autowired
	private ICompraDAO compraDAO;
	
	@Override
	public void crearCompra(Compra compra) {
		try {
			compraDAO.save(compra);
		} catch(Exception ex) {
			throw ex;
		}
	}
	
}
