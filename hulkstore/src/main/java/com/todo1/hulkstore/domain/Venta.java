package com.todo1.hulkstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VENTA")
public class Venta extends Movimiento {
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "venta")
	private List<LineaVenta> listaLineaVenta;
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;
	
	public Venta() {}

	public List<LineaVenta> getListaLineaVenta() {
		return listaLineaVenta;
	}

	public void setListaLineaVenta(List<LineaVenta> listaLineaVenta) {
		this.listaLineaVenta = listaLineaVenta;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
}
