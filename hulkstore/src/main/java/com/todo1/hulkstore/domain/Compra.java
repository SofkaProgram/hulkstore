package com.todo1.hulkstore.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPRA")
public class Compra extends Movimiento {
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "compra")
	private List<LineaCompra> listaLineaCompra;
	@ManyToOne
	@JoinColumn(name = "id_vendedor")
	private Vendedor vendedor;
	
	public Compra() {}

	public List<LineaCompra> getListaLineaCompra() {
		return listaLineaCompra;
	}
	
	public void setListaLineaCompra(List<LineaCompra> listaLineaCompra) {
		this.listaLineaCompra = listaLineaCompra;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}