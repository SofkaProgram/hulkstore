package com.todo1.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.todo1.hulkstore.domain.LineaCompra;
import com.todo1.hulkstore.domain.LineaInventario;
import com.todo1.hulkstore.domain.LineaVenta;
import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.Venta;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.domain.dto.VentaDTO;
import com.todo1.hulkstore.infraestructure.utility.JsonEntityConverter;
import com.todo1.hulkstore.service.ILineaInventarioService;
import com.todo1.hulkstore.service.ILineaVentaService;
import com.todo1.hulkstore.service.IProductoService;
import com.todo1.hulkstore.service.IVentaService;
import com.todo1.hulkstore.service.VentaService;

@Controller
public class CrearVentaController {
	@Autowired
	private IVentaService ventaService;
	@Autowired
	private IProductoService productoService;
	@Autowired
	private ILineaInventarioService lineaInventarioService;
	@Autowired
	private ILineaVentaService lineaVentaService;
	
	@Transactional
	public VentaDTO crearVenta(VentaDTO nuevaVenta) throws Exception {
		try {
			ProductoDTO nuevoProducto = nuevaVenta.getListaLineaVenta().get(0).getProducto();
			Producto producto = productoService.encontrarProducto(nuevoProducto);
			LineaInventario lineaInventario = producto.getLineaInventario();
			if(lineaInventario.getCantidad() == 0) {
				throw new Exception("No hay inventario (stock) disponible");
			} else if((lineaInventario.getCantidad() - nuevaVenta.getListaLineaVenta().get(0).getCantidad()) < 0) {
				throw new Exception("No hay inventario (stock) disponible");
			} 
			lineaInventario.setCantidad(lineaInventario.getCantidad() - nuevaVenta.getListaLineaVenta().get(0).getCantidad());
			Venta venta = JsonEntityConverter.generarVenta(nuevaVenta);
			this.crearVenta(venta, producto);
			VentaDTO ventaDTO = JsonEntityConverter.generarVentaDTO(venta);
			return ventaDTO;
		} catch(Exception ex) {
			throw ex;
		}
	}

	private void crearVenta(Venta venta, Producto producto) {
		this.crearLineaVenta(venta.getListaLineaVenta().get(0), producto);
		ventaService.crearVenta(venta);
		venta.getListaLineaVenta().get(0).setVenta(venta);
		lineaVentaService.actualizarLineaVenta(venta.getListaLineaVenta().get(0));
	}

	private void crearLineaVenta(LineaVenta lineaVenta, Producto producto) {
		lineaVenta.setProducto(producto);
		lineaVentaService.crearLineaVenta(lineaVenta);
	}

}
