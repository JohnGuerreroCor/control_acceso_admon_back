package com.usco.edu.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.usco.edu.entities.Asignado;

public class AsignadoRowMapper implements RowMapper<Asignado>{

	@Override
	public Asignado mapRow(ResultSet rs, int rowNum) throws SQLException {
		Asignado asignado = new Asignado();
		asignado.setCodigo(rs.getInt("puv_codigo"));
		asignado.setNombrePuesto(rs.getString("puv_nombre"));
		asignado.setSede(rs.getString("sed_nombre"));
		asignado.setSedeCodigo(rs.getInt("sed_codigo"));
		asignado.setSubsede(rs.getString("sus_nombre"));
		asignado.setSubsedeCodigo(rs.getInt("sus_codigo"));
		asignado.setBloque(rs.getString("blo_nombre"));
		asignado.setBloqueCodigo(rs.getInt("blo_codigo"));
		asignado.setTipoPuesto(rs.getString("pvt_nombre"));
		asignado.setTipoPuestoCodigo(rs.getInt("pvt_codigo"));
		asignado.setCupoVigilante(rs.getInt("puv_cupo_vigilante"));
		asignado.setAsignados(rs.getInt("asignados"));
		asignado.setEstado(rs.getInt("puv_estado"));
		return asignado;
	}
}
