package com.todo1.hulkstore.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo1.hulkstore.domain.LineaInventario;

public interface ILineaInventarioService {

	void actualizarLineaInventario(LineaInventario lineaInventario);

}
