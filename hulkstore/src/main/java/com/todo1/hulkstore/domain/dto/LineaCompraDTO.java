package com.todo1.hulkstore.domain.dto;

public class LineaCompraDTO {
	private Integer id;
	private int cantidad;
	private ProductoDTO producto;
	private CompraDTO compra;
	private int consecutivo;
	
	public LineaCompraDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	public CompraDTO getCompra() {
		return compra;
	}

	public void setCompra(CompraDTO compra) {
		this.compra = compra;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}
	
}
