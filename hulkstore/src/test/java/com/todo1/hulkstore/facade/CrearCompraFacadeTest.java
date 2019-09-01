package com.todo1.hulkstore.facade;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.todo1.hulkstore.domain.dto.CompraDTO;
import com.todo1.hulkstore.domain.dto.GenericResponse;
import com.todo1.hulkstore.domain.dto.LineaCompraDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrearCompraFacadeTest {
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Before
	public void setUp() throws Exception {
		RestTemplate productionRestTemplate = testRestTemplate.getRestTemplate();
		ClientHttpRequestFactory clientHttpRequestFactory = this.getClientHttpRequestFactory();
		productionRestTemplate.setRequestFactory(clientHttpRequestFactory);
	}

	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    final int timeout = 10000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
	      = new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    return clientHttpRequestFactory;
	}
	
	@Test
	public void crearCompraFacadeTest() {
		CompraDTO compra = this.configurarCompra();
		HttpEntity<CompraDTO> requestEntity = new HttpEntity<>(compra);
		ResponseEntity<GenericResponse> crearCompraResponse = 
				testRestTemplate.exchange("/api/compra/registrar", HttpMethod.POST, requestEntity, GenericResponse.class);
		GenericResponse genericResponse = crearCompraResponse.getBody();
		Assert.assertNotNull(genericResponse);
	}

	private CompraDTO configurarCompra() {
		CompraDTO compra = new CompraDTO();
		LineaCompraDTO lineaCompra = new LineaCompraDTO();
		// lineaCompra.setId(2);
		lineaCompra.setConsecutivo(1);
		lineaCompra.setCantidad(4);
		ProductoDTO producto = new ProductoDTO();
		producto.setId(1);
		lineaCompra.setProducto(producto);
		List<LineaCompraDTO> listaLineaCompra = new ArrayList<>();
		listaLineaCompra.add(lineaCompra);
		compra.setListaLineaCompra(listaLineaCompra);
		return compra;
	}
}
