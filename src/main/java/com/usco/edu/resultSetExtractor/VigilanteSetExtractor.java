package com.usco.edu.resultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.usco.edu.entities.Vigilante;
import com.usco.edu.rowMapper.VigilanteRowMapper;

public class VigilanteSetExtractor implements ResultSetExtractor<List<Vigilante>> {
	
	@Override
	public List<Vigilante> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Vigilante> list = new ArrayList<Vigilante>();
		while (rs.next()) {
			list.add(new VigilanteRowMapper().mapRow(rs, (rs.getRow() - 1)));
		}
		return list;
	}

}
