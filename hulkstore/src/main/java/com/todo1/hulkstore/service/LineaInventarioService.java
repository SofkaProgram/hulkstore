package com.todo1.hulkstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.domain.LineaInventario;
import com.todo1.hulkstore.domain.dao.ILineaInventarioDAO;

@Service
public class LineaInventarioService implements ILineaInventarioService {
	@Autowired
	private ILineaInventarioDAO lineaInventarioDAO;

	@Override
	public void actualizarLineaInventario(LineaInventario lineaInventario) {
		
	}

}
