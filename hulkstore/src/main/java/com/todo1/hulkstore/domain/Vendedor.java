package com.todo1.hulkstore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VENDEDOR")
public class Vendedor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String email;
	@Column
	private String contraseña;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
	private List<Venta> listaVenta;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendedor")
	private List<Compra> listaCompra;
	
	public Vendedor() {}

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

	public List<Venta> getListaVenta() {
		return listaVenta;
	}

	public void setListaVenta(List<Venta> listaVenta) {
		this.listaVenta = listaVenta;
	}

	public List<Compra> getListaCompra() {
		return listaCompra;
	}

	public void setListaCompra(List<Compra> listaCompra) {
		this.listaCompra = listaCompra;
	}

}
