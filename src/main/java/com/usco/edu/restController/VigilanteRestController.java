package com.usco.edu.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usco.edu.entities.Vigilante;
import com.usco.edu.service.IVigilanteService;

@RestController
@RequestMapping(path = "vigilante")
public class VigilanteRestController {
	
	@Autowired
	IVigilanteService vigilanteService;
	
	@GetMapping(path = "obtener-vigilantes/{username}")
	public List<Vigilante> obtenerVigilantes(@PathVariable String username) {
		
		return vigilanteService.obtenerVigilantes(username);
		
	}
	
	@GetMapping(path = "obtener-vigilantes-activos/{username}")
	public List<Vigilante> obtenerVigilantesActivos(@PathVariable String username) {
		
		return vigilanteService.obtenerVigilantesActivos(username);
		
	}
	
	@GetMapping(path = "obtener-vigilantes-sin-asignacion/{username}")
	public List<Vigilante> obtenerVigilantesSinAsignacion(@PathVariable String username) {
		
		return vigilanteService.obtenerVigilantesSinAsignacion(username);
		
	}
	
	@GetMapping(path = "obtener-vigilantes-identificacion/{id}/{username}")
	public List<Vigilante> obtenerVigilanteIdentificacion(@PathVariable String id, @PathVariable String username) {
		
		return vigilanteService.obtenerVigilanteIdentificacion(id, username);
		
	}
	
	@GetMapping(path = "obtener-vigilante-codigo/{codigo}/{username}")
	public List<Vigilante> obtenerVigilanteCodigo(@PathVariable int codigo, @PathVariable String username) {
		
		return vigilanteService.obtenerVigilanteCodigo(codigo, username);
		
	}
	
	
	@PostMapping(path = "registrar-vigilante/{user}")
	public int registrar(@PathVariable String user, @RequestBody Vigilante vigilante) {

		return vigilanteService.registrar(user, vigilante);
		
	}
	
	@PutMapping(path = "actualizar-vigilante/{user}")
	public int actualizar(@PathVariable String user, @RequestBody Vigilante vigilante) {
		
		return vigilanteService.actualizar(user, vigilante);
		
	}

}
