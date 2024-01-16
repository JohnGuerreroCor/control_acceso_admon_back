package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IAsignacionPuestoDao;
import com.usco.edu.entities.AsignacionPuesto;
import com.usco.edu.entities.Asignado;
import com.usco.edu.service.IAsignacionPuestoService;

@Service
public class AsignacionPuestoServiceImpl implements IAsignacionPuestoService {
	
	@Autowired
	private IAsignacionPuestoDao asignacionDao;
	

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestos(String userdb) {
		
		return asignacionDao.obtenerAsignacionPuestos(userdb);
		
	}

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestosActivos(String userdb) {
		
		return asignacionDao.obtenerAsignacionPuestosActivos(userdb);
		
	}

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigo(int codigo, String userdb) {
		
		return asignacionDao.obtenerAsignacionPuestoCodigo(codigo, userdb);
		
	}
	
	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigoPuesto(int codigo, String userdb) {
		
		return asignacionDao.obtenerAsignacionPuestoCodigoPuesto(codigo, userdb);
		
	}
	
	@Override
	public List<Asignado> obtenerAsignados(String userdb) {
		
		return asignacionDao.obtenerAsignados(userdb);
		
	}

	@Override
	public int registrar(String userdb, AsignacionPuesto puesto) {
		
		return asignacionDao.registrar(userdb, puesto);
	}

	@Override
	public int actualizar(String userdb, AsignacionPuesto puesto) {
		
		return asignacionDao.actualizar(userdb, puesto);
		
	}

}
