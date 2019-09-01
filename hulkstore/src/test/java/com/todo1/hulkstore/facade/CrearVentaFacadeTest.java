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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.todo1.hulkstore.domain.dto.GenericResponse;
import com.todo1.hulkstore.domain.dto.LineaVentaDTO;
import com.todo1.hulkstore.domain.dto.ProductoDTO;
import com.todo1.hulkstore.domain.dto.VentaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CrearVentaFacadeTest {
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
	public void crearVentaFacadeTest() {
		VentaDTO venta = this.configurarVenta();
		HttpEntity<VentaDTO> requestEntity = new HttpEntity<>(venta);
		ResponseEntity<GenericResponse> crearVentaResponse = 
				testRestTemplate.exchange("/api/venta/registrar", HttpMethod.POST, requestEntity, GenericResponse.class);
		GenericResponse genericResponse = crearVentaResponse.getBody();
		Assert.assertNotNull(genericResponse);
	}

	private VentaDTO configurarVenta() {
		VentaDTO venta = new VentaDTO();
		LineaVentaDTO lineaVenta = new LineaVentaDTO();
		// lineaVenta.setId(2);
		lineaVenta.setConsecutivo(1);
		lineaVenta.setCantidad(2);
		ProductoDTO producto = new ProductoDTO();
		producto.setId(1);
		lineaVenta.setProducto(producto);
		List<LineaVentaDTO> listaLineaVenta = new ArrayList<>();
		listaLineaVenta.add(lineaVenta);
		venta.setListaLineaVenta(listaLineaVenta);
		return venta;
	}
}
