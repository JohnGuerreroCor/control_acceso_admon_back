package com.usco.edu.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usco.edu.dao.IAdministrativoDao;
import com.usco.edu.entities.Administrativo;
import com.usco.edu.service.IAdministrativoService;

@Service
public class AdministrativoServiceImpl implements IAdministrativoService {
	
	@Autowired
	private IAdministrativoDao administrativoCarnetDao;

	@Override
	public List<Administrativo> findByIdentificacion(String id, String userdb) {
		
		return administrativoCarnetDao.findByIdentificacion(id, userdb);
		
	}

}
