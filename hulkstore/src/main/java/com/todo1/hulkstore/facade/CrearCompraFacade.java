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

import com.todo1.hulkstore.controller.CrearCompraController;
import com.todo1.hulkstore.domain.dto.CompraDTO;
import com.todo1.hulkstore.domain.dto.GenericResponse;
import com.todo1.hulkstore.infraestructure.utility.CompraDTOConverter;
import com.todo1.hulkstore.view.dto.CrearCompraDTO;

@Controller
@RequestMapping("/api/compra")
public class CrearCompraFacade {
	@Autowired
	private CrearCompraController crearCompraController;
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<GenericResponse> crearCompraJson(@RequestBody CrearCompraDTO crearCompra) {
		try {
			ResponseEntity<GenericResponse> crearCompraResponse = this.crearCompra(crearCompra);
			return crearCompraResponse;
		} catch(Exception ex) {
			GenericResponse genericResponse = new GenericResponse("fallo la creacion de la compra: "+ ex.getMessage());
			ResponseEntity<GenericResponse> crearCompraResponse = new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			return crearCompraResponse;
		}
	}
	
	@RequestMapping(value = "/registrar", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public String crearCompraEncoded(@Valid CrearCompraDTO crearCompra, BindingResult result, Model model) {
		try {
			if(result.hasErrors()) {
				CrearCompraDTO crearCompraFormulario = new CrearCompraDTO();
				model.addAttribute("crearCompra", crearCompraFormulario);
				return "crearCompra";
			}
			this.crearCompra(crearCompra);
			return "crearCompraExito";
		} catch(Exception ex) {
			GenericResponse genericResponse = new GenericResponse("fallo la creacion de la compra: "+ ex.getMessage());
			ResponseEntity<GenericResponse> crearCompraResponse = new ResponseEntity<>(genericResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			model.addAttribute("errorCrearCompra", "fallo la creacion de la compra: "+ ex.getMessage());
			return "crearCompraFallo";
		}
	}
	
	private ResponseEntity<GenericResponse> crearCompra(CrearCompraDTO crearCompra) throws Exception {
		CompraDTO compraDTO = CompraDTOConverter.crearCompra(crearCompra);
		CompraDTO compraCreada = crearCompraController.crearCompra(compraDTO);
		GenericResponse genericResponse = new GenericResponse("exito creando la compra");
		ResponseEntity<GenericResponse> crearCompraResponse = new ResponseEntity<>(genericResponse, HttpStatus.OK);
		return crearCompraResponse;
	}
}
