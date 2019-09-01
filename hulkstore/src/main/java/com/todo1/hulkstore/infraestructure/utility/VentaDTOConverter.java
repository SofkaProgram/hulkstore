package com.todo1.hulkstore.infraestructure.utility;

import java.util.ArrayList;
import java.util.List;

import com.todo1.hulkstore.domain.dto.LineaVentaDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.domain.dto.VentaDTO;
import com.todo1.hulkstore.view.dto.CrearVentaDTO;

public final class VentaDTOConverter {

	public static VentaDTO convert(CrearVentaDTO crearVenta) {
		VentaDTO venta = new VentaDTO();
		LineaVentaDTO lineaVenta = new LineaVentaDTO();
		// lineaVenta.setId(1); (ID AUTOGENERADO)
		lineaVenta.setConsecutivo(1);
		lineaVenta.setCantidad(crearVenta.getCantidad());
		ProductoDTO producto = new ProductoDTO();
		producto.setId(crearVenta.getIdProducto());
		lineaVenta.setProducto(producto);
		List<LineaVentaDTO> listaLineaVenta = new ArrayList<>();
		listaLineaVenta.add(lineaVenta);
		venta.setListaLineaVenta(listaLineaVenta);
		return venta;
	}
	
}
