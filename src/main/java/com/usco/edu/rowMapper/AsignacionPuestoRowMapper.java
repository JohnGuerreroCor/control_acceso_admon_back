package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.AsignacionPuesto;

public class AsignacionPuestoRowMapper implements RowMapper<AsignacionPuesto>{
	
	@Override
	public AsignacionPuesto mapRow(ResultSet rs, int rowNum) throws SQLException {
		AsignacionPuesto asignacion = new AsignacionPuesto();
		asignacion.setCodigo(rs.getInt("asp_codigo"));
		asignacion.setPuesto(new PuestoVigilanciaRowMapper().mapRow(rs, rowNum));
		asignacion.setVigilante(new VigilanteRowMapper().mapRow(rs, rowNum));
		asignacion.setObservacion(rs.getString("asp_observacion"));
		asignacion.setFechaCreacion(rs.getDate("asp_fecha_creacion"));
		asignacion.setFechaRetiro(rs.getDate("asp_fecha_retiro"));
		asignacion.setEstado(rs.getInt("asp_estado"));
		return asignacion;
	}
}
