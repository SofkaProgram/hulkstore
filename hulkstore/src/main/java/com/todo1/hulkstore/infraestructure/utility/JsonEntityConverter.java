package com.todo1.hulkstore.infraestructure.utility;

import org.modelmapper.ModelMapper;

import com.todo1.hulkstore.domain.Compra;
import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.Venta;
import com.todo1.hulkstore.domain.dto.CompraDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.domain.dto.VentaDTO;


public class JsonEntityConverter {
	public static VentaDTO generarVentaDTO(Venta venta) {
		ModelMapper dtoMapper = new ModelMapper();
		dtoMapper.getConfiguration().setAmbiguityIgnored(true);
		VentaDTO ventaDTO = dtoMapper.map(venta, VentaDTO.class);
		return ventaDTO;
	}
	
	public static Venta generarVenta(VentaDTO ventaDTO) {
		ModelMapper dtoMapper = new ModelMapper();
		dtoMapper.getConfiguration().setAmbiguityIgnored(true);
		Venta venta = dtoMapper.map(ventaDTO, Venta.class);
		return venta;
	}

	public static Compra generarCompra(CompraDTO compraDTO) {
		ModelMapper dtoMapper = new ModelMapper();
		dtoMapper.getConfiguration().setAmbiguityIgnored(true);
		Compra compra = dtoMapper.map(compraDTO, Compra.class);
		return compra;
	}

	public static CompraDTO generarCompraDTO(Compra compra) {
		ModelMapper dtoMapper = new ModelMapper();
		dtoMapper.getConfiguration().setAmbiguityIgnored(true);
		CompraDTO compraDTO = dtoMapper.map(compra, CompraDTO.class);
		return compraDTO;
	}

	public static ProductoDTO generarProductoDTO(Producto producto) {
		ModelMapper dtoMapper = new ModelMapper();
		dtoMapper.getConfiguration().setAmbiguityIgnored(true);
		ProductoDTO productoDTO = dtoMapper.map(producto, ProductoDTO.class);
		return productoDTO;
	}
}
