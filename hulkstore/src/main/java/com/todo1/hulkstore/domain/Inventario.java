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
@Table(name = "INVENTARIO")
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inventario")
	private List<LineaInventario> listaLineaInventario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<LineaInventario> getListaLineaInventario() {
		return listaLineaInventario;
	}
	public void setListaLineaInventario(List<LineaInventario> listaLineaInventario) {
		this.listaLineaInventario = listaLineaInventario;
	}
}