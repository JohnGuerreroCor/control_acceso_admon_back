package com.usco.edu.dao;

import java.util.List;

import com.usco.edu.entities.AsignacionPuesto;
import com.usco.edu.entities.Asignado;

public interface IAsignacionPuestoDao {
	
	public List<AsignacionPuesto> obtenerAsignacionPuestos(String userdb);
	
	public List<AsignacionPuesto> obtenerAsignacionPuestosActivos(String userdb);
	
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigo(int codigo, String userdb);
	
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigoPuesto(int codigo, String userdb);
	
	public List<Asignado> obtenerAsignados(String userdb);
	
	public int registrar(String userdb, AsignacionPuesto puesto);
	
	int actualizar(String userdb, AsignacionPuesto puesto);

}
