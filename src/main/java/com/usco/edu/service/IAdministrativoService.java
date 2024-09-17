package com.usco.edu.service;

import java.util.List;

import com.usco.edu.entities.Administrativo;

public interface IAdministrativoService {
	
	public List<Administrativo> findByIdentificacion(String id, String userdb);

}
