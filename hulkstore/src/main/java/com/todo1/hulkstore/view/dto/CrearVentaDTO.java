package com.todo1.hulkstore.view.dto;

import javax.validation.constraints.NotNull;

public class CrearVentaDTO {
	@NotNull
	private Integer cantidad;
	@NotNull
	private Integer idProducto;
	
	public CrearVentaDTO() {}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	
}
