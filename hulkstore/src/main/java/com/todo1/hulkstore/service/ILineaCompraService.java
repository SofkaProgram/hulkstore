package com.todo1.hulkstore.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo1.hulkstore.domain.LineaCompra;

public interface ILineaCompraService {

	void actualizarLineaCompra(LineaCompra lineaCompra);

	void crearLineaCompra(LineaCompra lineaCompra);

}
