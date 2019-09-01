package com.todo1.hulkstore.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column
	private String nombre;
	@Column
	private String estado;
	@OneToOne
	@JoinColumn(name = "id_linea_inventario")
	private LineaInventario lineaInventario;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private List<LineaVenta> listaLineaVenta;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
	private List<LineaCompra> listaLineaCompra;
	
	public Producto() {}
	
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
	public LineaInventario getLineaInventario() {
		return lineaInventario;
	}
	public void setLineaInventario(LineaInventario lineaInventario) {
		this.lineaInventario = lineaInventario;
	}
	public List<LineaVenta> getListaLineaVenta() {
		return listaLineaVenta;
	}
	public void setListaLineaVenta(List<LineaVenta> listaLineaVenta) {
		this.listaLineaVenta = listaLineaVenta;
	}
	public List<LineaCompra> getListaLineaCompra() {
		return listaLineaCompra;
	}
	public void setListaLineaCompra(List<LineaCompra> listaLineaCompra) {
		this.listaLineaCompra = listaLineaCompra;
	}
}