package com.todo1.hulkstore.infraestructure.utility;

import java.util.ArrayList;
import java.util.List;

import com.todo1.hulkstore.domain.dto.CompraDTO;
import com.todo1.hulkstore.domain.dto.LineaCompraDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.view.dto.CrearCompraDTO;

public final class CompraDTOConverter {

	public static CompraDTO crearCompra(CrearCompraDTO crearCompra) {
		CompraDTO compra = new CompraDTO();
		LineaCompraDTO lineaCompra = new LineaCompraDTO();
		// lineaCompra.setId(1); (ID autogenerado)
		lineaCompra.setConsecutivo(1);
		lineaCompra.setCantidad(crearCompra.getCantidad());
		ProductoDTO producto = new ProductoDTO();
		producto.setId(crearCompra.getIdProducto());
		lineaCompra.setProducto(producto);
		List<LineaCompraDTO> listaLineaCompra = new ArrayList<>();
		listaLineaCompra.add(lineaCompra);
		compra.setListaLineaCompra(listaLineaCompra);
		return compra;
	}
	
}
