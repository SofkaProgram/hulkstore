package com.todo1.hulkstore.facade;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.controller.CrearVentaController;
import com.todo1.hulkstore.domain.dto.GenericResponse;
import com.todo1.hulkstore.domain.dto.VentaDTO;
import com.todo1.hulkstore.infraestructure.utility.VentaDTOConverter;
import com.todo1.hulkstore.view.dto.CrearCompraDTO;
import com.todo1.hulkstore.view.dto.CrearVentaDTO;

@Controller
@RequestMapping("/api/venta")
public class CrearVentaFacade {
	@Autowired
	private CrearVentaController crearVentaController;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<GenericResponse> crearVentaJson(@RequestBody CrearVentaDTO nuevaVenta) {
		try {
			ResponseEntity<GenericResponse> genericResponse = this.crearVenta(nuevaVenta);
			return genericResponse;
		} catch(Exception ex) {
			GenericResponse genericResponse = new GenericResponse("fallo la creacion de la venta: "+ ex.getMessage());
			ResponseEntity<GenericResponse> crearVentaResponse = new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			return crearVentaResponse;
		}
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public String crearVentaEncoded(@Valid CrearVentaDTO nuevaVenta, BindingResult result, Model model) {
		try {
			if(result.hasErrors()) {
				CrearVentaDTO crearVentaFormulario = new CrearVentaDTO();
				model.addAttribute("crearVenta", crearVentaFormulario);
				return "crearVenta";
			}
			this.crearVenta(nuevaVenta);
			return "crearVentaExito";
		} catch(Exception ex) {
			GenericResponse genericResponse = new GenericResponse("fallo la creacion de la venta: "+ ex.getMessage());
			ResponseEntity<GenericResponse> crearVentaResponse = new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorCrearVenta", "fallo la creacion de la venta: "+ ex.getMessage());
			return "crearVentaFallo";
		}
	}
	
	public ResponseEntity<GenericResponse> crearVenta(CrearVentaDTO crearVenta) throws Exception {
		VentaDTO nuevaVenta = VentaDTOConverter.convert(crearVenta);
		VentaDTO ventaCreada = crearVentaController.crearVenta(nuevaVenta);
		GenericResponse genericResponse = new GenericResponse("exito creando la venta");
		ResponseEntity<GenericResponse> crearVentaResponse = new ResponseEntity<>(genericResponse, HttpStatus.OK);
		return crearVentaResponse;
	}
}
