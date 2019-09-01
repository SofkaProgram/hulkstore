package com.todo1.hulkstore.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.todo1.hulkstore.domain.LineaInventario;
import com.todo1.hulkstore.domain.Producto;
import com.todo1.hulkstore.domain.dao.ILineaInventarioDAO;
import com.todo1.hulkstore.domain.dao.IProductoDAO;

@Component
public class DataInit implements ApplicationRunner {
	@Autowired
	private IProductoDAO productoDAO;
	@Autowired
	private ILineaInventarioDAO lineaInventarioDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {
			Producto producto = new Producto();
			producto.setNombre("Alfalfa");
			productoDAO.save(producto);
			LineaInventario lineaInventario = new LineaInventario();
			lineaInventario.setCantidad(10);
			lineaInventario.setProducto(producto);
			lineaInventarioDAO.save(lineaInventario);
			producto.setLineaInventario(lineaInventario);
			productoDAO.save(producto);
			
			Producto producto2 = new Producto();
			producto2.setNombre("Tomate");
			productoDAO.save(producto2);
			LineaInventario lineaInventario2 = new LineaInventario();
			lineaInventario2.setCantidad(7);
			lineaInventario2.setProducto(producto2);
			lineaInventarioDAO.save(lineaInventario2);
			producto2.setLineaInventario(lineaInventario2);
			productoDAO.save(producto2);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
