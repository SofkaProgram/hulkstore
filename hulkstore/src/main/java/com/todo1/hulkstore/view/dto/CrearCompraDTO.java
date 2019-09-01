package com.todo1.hulkstore.view.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CrearCompraDTO {
	@NotNull(message = "La cantidad no puede estar vacia")
	private Integer cantidad;
	@NotNull(message = "El id del producto no puede estar vacio")
	private Integer idProducto;
	
	public CrearCompraDTO() {}

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
