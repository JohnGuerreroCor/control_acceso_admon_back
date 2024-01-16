package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.AsignacionPuesto;
import com.usco.edu.rowMapper.AsignacionPuestoRowMapper;

public class AsignacionPuestoSetExtractor  implements ResultSetExtractor<List<AsignacionPuesto>> {
	
	@Override
	public List<AsignacionPuesto> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AsignacionPuesto> list = new ArrayList<AsignacionPuesto>();
		while (rs.next()) {
			list.add(new AsignacionPuestoRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}
	
}
