package com.todo1.hulkstore.domain.dto;

import java.util.List;

public class VendedorDTO {
	private Integer id;
	private String nombre;
	private String email;
	private String contraseña;
	private List<VentaDTO> listaVenta;
	private List<CompraDTO> listaCompra;
	
	public VendedorDTO() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public List<VentaDTO> getListaVenta() {
		return listaVenta;
	}

	public void setListaVenta(List<VentaDTO> listaVenta) {
		this.listaVenta = listaVenta;
	}

	public List<CompraDTO> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<CompraDTO> listaCompra) {
		this.listaCompra = listaCompra;
	}
	
	
}
