package com.usco.edu.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IVigilanteDao;
import com.usco.edu.entities.Vigilante;
import com.usco.edu.service.IVigilanteService;

@Service
public class VigilanteServiceImpl implements IVigilanteService {
	
	@Autowired
	private IVigilanteDao vigilanteDao;

	@Override
	public List<Vigilante> obtenerVigilantes(String userdb) {
		
		return vigilanteDao.obtenerVigilantes(userdb);
		
	}

	@Override
	public List<Vigilante> obtenerVigilantesActivos(String userdb) {
		
		return vigilanteDao.obtenerVigilantesActivos(userdb);
		
	}
	
	@Override
	public List<Vigilante> obtenerVigilantesSinAsignacion(String userdb) {
		
		return vigilanteDao.obtenerVigilantesSinAsignacion(userdb);
		
	}

	@Override
	public List<Vigilante> obtenerVigilanteIdentificacion(String id, String userdb) {
		
		return vigilanteDao.obtenerVigilanteIdentificacion(id, userdb);
		
	}

	@Override
	public List<Vigilante> obtenerVigilanteCodigo(int codigo, String userdb) {
		
		return vigilanteDao.obtenerVigilanteCodigo(codigo, userdb);
		
	}

	@Override
	public int registrar(String userdb, Vigilante vigilante) {
		
		return vigilanteDao.registrar(userdb, vigilante);
		
	}

	@Override
	public int actualizar(String userdb, Vigilante vigilante) {
		
		return vigilanteDao.actualizar(userdb, vigilante);
		
	}
	
}
