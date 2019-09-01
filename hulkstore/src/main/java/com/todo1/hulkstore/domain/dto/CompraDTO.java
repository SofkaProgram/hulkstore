package com.todo1.hulkstore.domain.dto;

import java.util.List;

public class CompraDTO extends MovimientoDTO {
	private List<LineaCompraDTO> listaLineaCompra;
	
	public CompraDTO() {}
	
	public List<LineaCompraDTO> getListaLineaCompra() {
		return listaLineaCompra;
	}
	public void setListaLineaCompra(List<LineaCompraDTO> listaLineaCompra) {
		this.listaLineaCompra = listaLineaCompra;
	}
}
