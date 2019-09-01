package com.todo1.hulkstore.domain.dto;

import java.util.List;

public class InventarioDTO {
	private Integer id;
	private List<LineaInventarioDTO> listaLineaInventario;
	public InventarioDTO() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<LineaInventarioDTO> getListaLineaInventario() {
		return listaLineaInventario;
	}
	public void setListaLineaInventario(List<LineaInventarioDTO> listaLineaInventario) {
		this.listaLineaInventario = listaLineaInventario;
	}
	
}
