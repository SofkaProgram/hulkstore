package com.todo1.hulkstore.domain.dto;

public class LineaInventarioDTO {
	private Integer id;
	private int cantidad;
	private ProductoDTO producto;
	private InventarioDTO inventario;
	
	public LineaInventarioDTO() {}

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

	public InventarioDTO getInventario() {
		return inventario;
	}

	public void setInventario(InventarioDTO inventario) {
		this.inventario = inventario;
	}

	
	
	
}
