package com.todo1.hulkstore.domain.dto;

import java.util.List;

public class VentaDTO extends MovimientoDTO {
	private List<LineaVentaDTO> listaLineaVenta;
	private VendedorDTO vendedor;
	
	public VentaDTO() {}
	
	public List<LineaVentaDTO> getListaLineaVenta() {
		return listaLineaVenta;
	}
	public void setListaLineaVenta(List<LineaVentaDTO> listaLineaVenta) {
		this.listaLineaVenta = listaLineaVenta;
	}
	public VendedorDTO getVendedor() {
		return vendedor;
	}
	public void setVendedor(VendedorDTO vendedor) {
		this.vendedor = vendedor;
	}
}
