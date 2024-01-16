package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.Vigilante;

public interface IVigilanteDao {
	
	public List<Vigilante> obtenerVigilantes(String userdb);
	
	public List<Vigilante> obtenerVigilantesActivos(String userdb);
	
	public List<Vigilante> obtenerVigilantesSinAsignacion(String userdb);
	
	public List<Vigilante> obtenerVigilanteIdentificacion(String id, String userdb);
	
	public List<Vigilante> obtenerVigilanteCodigo(int codigo, String userdb);
	
	public int registrar(String userdb, Vigilante vigilante);
	
	int actualizar(String userdb, Vigilante vigilante);

}
