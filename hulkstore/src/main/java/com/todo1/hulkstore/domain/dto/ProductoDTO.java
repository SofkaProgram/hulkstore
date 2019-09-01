package com.todo1.hulkstore.domain.dto;

import java.util.List;

public class ProductoDTO {
	private Integer id;
	private String nombre;
	private String estado;
	private LineaInventarioDTO lineaInventario;
	private List<LineaVentaDTO> listaLineaVenta;
	private List<LineaCompraDTO> listaLineaCompra;
	
	public ProductoDTO() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LineaInventarioDTO getLineaInventario() {
		return lineaInventario;
	}

	public void setLineaInventario(LineaInventarioDTO lineaInventario) {
		this.lineaInventario = lineaInventario;
	}

	public List<LineaVentaDTO> getListaLineaVenta() {
		return listaLineaVenta;
	}

	public void setListaLineaVenta(List<LineaVentaDTO> listaLineaVenta) {
		this.listaLineaVenta = listaLineaVenta;
	}

	public List<LineaCompraDTO> getListaLineaCompra() {
		return listaLineaCompra;
	}

	public void setListaLineaCompra(List<LineaCompraDTO> listaLineaCompra) {
		this.listaLineaCompra = listaLineaCompra;
	}
	
}
