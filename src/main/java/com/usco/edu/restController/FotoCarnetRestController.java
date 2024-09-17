package com.usco.edu.restController;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.dto.FotoAntigua;
import com.usco.edu.service.IFotoCarnetService;

@RestController
@RequestMapping(path = "foto")
public class FotoCarnetRestController {

	@Autowired
	private IFotoCarnetService service;

	@GetMapping("obtener-foto/{codigo}")
	public ResponseEntity<InputStreamResource> foto(HttpServletResponse response, @PathVariable String codigo)
			throws Exception {
		ByteArrayInputStream stream = service.mirarFoto(codigo, response);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=\" foto.png\"");

		return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));

	}

	@GetMapping(path = "obtener-foto-antigua/{codigo}")
	public FotoAntigua fotoAntigua(@PathVariable String codigo) throws Exception {
		return service.mirarFotoAntigua(codigo);
	}
}
