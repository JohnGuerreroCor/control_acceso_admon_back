package com.usco.edu.dao.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.usco.edu.dao.IVigilanteDao;
import com.usco.edu.entities.Vigilante;
import com.usco.edu.resultSetExtractor.VigilanteSetExtractor;
import com.usco.edu.util.AuditoriaJdbcTemplate;

@Repository
public class VigilanteDaoImpl implements IVigilanteDao {
	
	@Autowired
	private AuditoriaJdbcTemplate jdbcComponent;
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<Vigilante> obtenerVigilantes(String userdb) {
		
		String sql = "select * from carnetizacion.vigilante v "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo ";
		return jdbcTemplate.query(sql, new VigilanteSetExtractor());
		
	}
	
	@Override
	public List<Vigilante> obtenerVigilantesActivos(String userdb) {
		
		String sql = "select * from carnetizacion.vigilante v "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where v.vig_estado = 1 ";
		return jdbcTemplate.query(sql, new VigilanteSetExtractor());
		
	}
	
	@Override
	public List<Vigilante> obtenerVigilantesSinAsignacion(String userdb) {
		
		String sql = "SELECT * FROM carnetizacion.vigilante v "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "WHERE NOT EXISTS ( SELECT * FROM carnetizacion.asignacion_puesto ap WHERE v.vig_codigo = ap.vig_codigo and ap.asp_estado != 0 ); ";
		return jdbcTemplate.query(sql, new VigilanteSetExtractor());
		
	}


	@Override
	public List<Vigilante> obtenerVigilanteIdentificacion(String id, String userdb) {
		
		String sql = "select * from carnetizacion.vigilante v "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where v.vig_identificacion = '"+ id +"' and v.vig_estado = 1 ";
		return jdbcTemplate.query(sql, new VigilanteSetExtractor());
		
	}


	@Override
	public List<Vigilante> obtenerVigilanteCodigo(int codigo, String userdb) {
		
		String sql = "select * from carnetizacion.vigilante v "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where v.vig_codigo = '"+ codigo +"' and v.vig_estado = 1 ";
		return jdbcTemplate.query(sql, new VigilanteSetExtractor());
		
	}


	@Override
	public int registrar(String userdb, Vigilante vigilante) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO carnetizacion.vigilante "
				+ "(tii_codigo, vig_identificacion, vig_nombre, vig_apellido, vig_email, vig_empresa) "
				+ "VALUES(:documento, :identificacion, :nombre, :apellido, :correo, :empresa);";
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("documento", vigilante.getDocumento().getCodigo());
			parameter.addValue("identificacion", vigilante.getIdentificacion());
			parameter.addValue("nombre", vigilante.getNombre());
			parameter.addValue("apellido", vigilante.getApellido());
			parameter.addValue("correo", vigilante.getCorreo());
			parameter.addValue("empresa", vigilante.getEmpresa());

			jdbc.update(sql, parameter, keyHolder);
			return keyHolder.getKey().intValue();

		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public int actualizar(String userdb, Vigilante vigilante) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE carnetizacion.vigilante "
				+ "SET tii_codigo=:documento, vig_identificacion=:identificacion, vig_nombre=:nombre, vig_apellido=:apellido, "
				+ "vig_email=:correo, vig_empresa=:empresa, vig_fecha_retiro=:retiro, vig_estado=:estado "
				+ "WHERE vig_codigo=:codigo";

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("codigo", vigilante.getCodigo());
			parameter.addValue("documento", vigilante.getDocumento().getCodigo());
			parameter.addValue("identificacion", vigilante.getIdentificacion());
			parameter.addValue("nombre", vigilante.getNombre());
			parameter.addValue("apellido", vigilante.getApellido());
			parameter.addValue("correo", vigilante.getCorreo());
			parameter.addValue("empresa", vigilante.getEmpresa());
			parameter.addValue("retiro", vigilante.getFechaRetiro(), Types.DATE);
			parameter.addValue("estado", vigilante.getEstado());

			return jdbc.update(sql, parameter);
		} catch (Exception e) {

			e.printStackTrace();
			return 0;
		} finally {
			try {
				cerrarConexion(dataSource.getConnection());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void cerrarConexion(Connection con) {
		if (con == null)
			return;

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
