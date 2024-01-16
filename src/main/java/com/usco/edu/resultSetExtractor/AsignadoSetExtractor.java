package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Asignado;
import com.usco.edu.rowMapper.AsignadoRowMapper;


public class AsignadoSetExtractor implements ResultSetExtractor<List<Asignado>> {
	
	@Override
	public List<Asignado> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Asignado> list = new ArrayList<Asignado>();
		while (rs.next()) {
			list.add(new AsignadoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}

}
