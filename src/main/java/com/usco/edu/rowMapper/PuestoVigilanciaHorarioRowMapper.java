package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.PuestoVigilancia;

public class PuestoVigilanciaHorarioRowMapper implements RowMapper<PuestoVigilancia>{

	@Override
	public PuestoVigilancia mapRow(ResultSet rs, int rowNum) throws SQLException {
		PuestoVigilancia puestoVigilancia = new PuestoVigilancia();
		puestoVigilancia.setCodigo(rs.getInt("puv_codigo"));
		puestoVigilancia.setNombre(rs.getString("puv_nombre"));
		puestoVigilancia.setCupoVigilante(rs.getInt("puv_cupo_vigilante"));
		puestoVigilancia.setEstado(rs.getInt("puv_estado"));
		return puestoVigilancia;
	}
}
