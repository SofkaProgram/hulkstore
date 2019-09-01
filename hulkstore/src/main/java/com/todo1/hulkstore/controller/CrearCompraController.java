package com.todo1.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.domain.Compra;
import com.todo1.hulkstore.domain.LineaCompra;
import com.todo1.hulkstore.domain.LineaInventario;
import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.dto.CompraDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.infraestructure.utility.JsonEntityConverter;
import com.todo1.hulkstore.service.ICompraService;
import com.todo1.hulkstore.service.ILineaCompraService;
import com.todo1.hulkstore.service.IProductoService;

@Controller
public class CrearCompraController {
	@Autowired
	private ICompraService compraService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private ILineaCompraService lineaCompraService;

	@Transactional
	public CompraDTO crearCompra(CompraDTO nuevaCompra) throws Exception {
		try {
			ProductoDTO nuevoProducto = nuevaCompra.getListaLineaCompra().get(0).getProducto();
			Producto producto = productoService.encontrarProducto(nuevoProducto);
			LineaInventario lineaInventario = producto.getLineaInventario();
			if(lineaInventario.getCantidad() == 0) {
				throw new Exception("No hay inventario (stock) disponible");
			} 
			lineaInventario.setCantidad(lineaInventario.getCantidad() + nuevaCompra.getListaLineaCompra().get(0).getCantidad());
			Compra compra = JsonEntityConverter.generarCompra(nuevaCompra);
			this.crearCompra(compra, producto);
			CompraDTO compraDTO = JsonEntityConverter.generarCompraDTO(compra);
			return compraDTO;
		} catch(Exception ex) {
			throw ex;
		}
	}

	private void crearCompra(Compra compra, Producto producto) {
		this.crearLineaCompra(compra.getListaLineaCompra().get(0), producto);
		compraService.crearCompra(compra);
		compra.getListaLineaCompra().get(0).setCompra(compra);
		lineaCompraService.actualizarLineaCompra(compra.getListaLineaCompra().get(0));
	}

	private void crearLineaCompra(LineaCompra lineaCompra, Producto producto) {
		lineaCompra.setProducto(producto);
		lineaCompraService.crearLineaCompra(lineaCompra);
	}

}
