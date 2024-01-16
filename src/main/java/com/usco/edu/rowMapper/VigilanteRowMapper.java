package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Vigilante;

public class VigilanteRowMapper implements RowMapper<Vigilante>{
	
	@Override
	public Vigilante mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vigilante vigilante = new Vigilante();
		vigilante.setCodigo(rs.getInt("vig_codigo"));
		vigilante.setDocumento(new TipoDocumentoRowMapper().mapRow(rs, rowNum));
		vigilante.setIdentificacion(rs.getString("vig_identificacion"));
		vigilante.setNombre(rs.getString("vig_nombre"));
		vigilante.setApellido(rs.getString("vig_apellido"));
		vigilante.setCorreo(rs.getString("vig_email"));
		vigilante.setEmpresa(rs.getString("vig_empresa"));
		vigilante.setFechaCreacion(rs.getDate("vig_fecha_creacion"));
		vigilante.setFechaRetiro(rs.getDate("vig_fecha_retiro"));
		vigilante.setEstado(rs.getInt("vig_estado"));
		return vigilante;
	}

}
