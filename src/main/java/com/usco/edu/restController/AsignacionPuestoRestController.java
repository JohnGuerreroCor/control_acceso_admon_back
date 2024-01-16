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

import com.usco.edu.entities.AsignacionPuesto;
import com.usco.edu.entities.Asignado;
import com.usco.edu.service.IAsignacionPuestoService;

@RestController
@RequestMapping(path = "asignacion")
public class AsignacionPuestoRestController {
	
	@Autowired
	IAsignacionPuestoService asignacionService;
	
	@GetMapping(path = "obtener-asignaciones/{username}")
	public List<AsignacionPuesto> obtenerAsignacionPuestos(@PathVariable String username) {
		
		return asignacionService.obtenerAsignacionPuestos(username);
		
	}
	
	@GetMapping(path = "obtener-asignaciones-activos/{username}")
	public List<AsignacionPuesto> obtenerVigilantesActivos(@PathVariable String username) {
		
		return asignacionService.obtenerAsignacionPuestosActivos(username);
		
	}
	
	
	@GetMapping(path = "obtener-asignacion-codigo/{codigo}/{username}")
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigo(@PathVariable int codigo, @PathVariable String username) {
		
		return asignacionService.obtenerAsignacionPuestoCodigo(codigo, username);
		
	}
	
	@GetMapping(path = "obtener-asignacion-codigo-puesto/{codigo}/{username}")
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigoPuesto(@PathVariable int codigo, @PathVariable String username) {
		
		return asignacionService.obtenerAsignacionPuestoCodigoPuesto(codigo, username);
		
	}
	
	
	@GetMapping(path = "obtener-asignados/{username}")
	public List<Asignado> obtenerAsignados(@PathVariable String username) {
		
		return asignacionService.obtenerAsignados(username);
		
	}
	
	
	@PostMapping(path = "registrar-asignacion/{user}")
	public int registrar(@PathVariable String user, @RequestBody AsignacionPuesto asignacion) {

		return asignacionService.registrar(user, asignacion);
		
	}
	
	@PutMapping(path = "actualizar-asignacion/{user}")
	public int actualizar(@PathVariable String user, @RequestBody AsignacionPuesto asignacion) {
		
		return asignacionService.actualizar(user, asignacion);
		
	}

}
