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

import com.usco.edu.dao.IAsignacionPuestoDao;
import com.usco.edu.entities.AsignacionPuesto;
import com.usco.edu.entities.Asignado;
import com.usco.edu.resultSetExtractor.AsignacionPuestoSetExtractor;
import com.usco.edu.resultSetExtractor.AsignadoSetExtractor;
import com.usco.edu.util.AuditoriaJdbcTemplate;

@Repository
public class AsignacionPuestoDaoImpl implements IAsignacionPuestoDao {
	
	@Autowired
	private AuditoriaJdbcTemplate jdbcComponent;
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestos(String userdb) {
		
		String sql = "select * from carnetizacion.asignacion_puesto ap "
				+ "inner join carnetizacion.puesto_vigilancia pv on ap.puv_codigo = pv.puv_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.vigilante v on ap.vig_codigo = v.vig_codigo "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo ";
		return jdbcTemplate.query(sql, new AsignacionPuestoSetExtractor());
		
	}

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestosActivos(String userdb) {
		
		String sql = "select * from carnetizacion.asignacion_puesto ap "
				+ "inner join carnetizacion.puesto_vigilancia pv on ap.puv_codigo = pv.puv_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.vigilante v on ap.vig_codigo = v.vig_codigo "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where ap.asp_estado = 1";
		return jdbcTemplate.query(sql, new AsignacionPuestoSetExtractor());
		
	}

	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigo(int codigo, String userdb) {
		
		String sql = "select * from carnetizacion.asignacion_puesto ap "
				+ "inner join carnetizacion.puesto_vigilancia pv on ap.puv_codigo = pv.puv_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.vigilante v on ap.vig_codigo = v.vig_codigo "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where ap.asp_codigo = " + codigo + " and ap.asp_estado = 1";
		return jdbcTemplate.query(sql, new AsignacionPuestoSetExtractor());
		
	}
	
	@Override
	public List<AsignacionPuesto> obtenerAsignacionPuestoCodigoPuesto(int codigo, String userdb) {
		
		String sql = "select * from carnetizacion.asignacion_puesto ap "
				+ "inner join carnetizacion.puesto_vigilancia pv on ap.puv_codigo = pv.puv_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.vigilante v on ap.vig_codigo = v.vig_codigo "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where ap.puv_codigo = " + codigo + " and ap.asp_estado = 1";
		return jdbcTemplate.query(sql, new AsignacionPuestoSetExtractor());
		
	}
	
	@Override
	public List<Asignado> obtenerAsignados(String userdb) {
		String sql = "select ap.puv_codigo, pv.puv_nombre, pv.puv_estado, s.sed_nombre, s.sed_codigo, ss.sus_nombre, ss.sus_codigo, b.blo_nombre, b.blo_codigo, pvt.pvt_nombre, pvt.pvt_codigo, pv.puv_cupo_vigilante, count(ap.vig_codigo) as asignados from carnetizacion.asignacion_puesto ap "
				+ "inner join carnetizacion.puesto_vigilancia pv on ap.puv_codigo = pv.puv_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.vigilante v on ap.vig_codigo = v.vig_codigo "
				+ "inner join tipo_id ti on v.tii_codigo = ti.tii_codigo "
				+ "where ap.asp_estado = 1"
				+ "group by ap.puv_codigo, pv.puv_nombre, pv.puv_estado, s.sed_nombre, s.sed_codigo, ss.sus_nombre, ss.sus_codigo, b.blo_nombre, b.blo_codigo, pvt.pvt_nombre, pvt.pvt_codigo, pv.puv_cupo_vigilante";
		return jdbcTemplate.query(sql, new AsignadoSetExtractor());
	}

	@Override
	public int registrar(String userdb, AsignacionPuesto puesto) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO carnetizacion.asignacion_puesto "
				+ "(puv_codigo, vig_codigo, asp_observacion) "
				+ "VALUES(:puesto, :vigilante, :observacion);";
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("puesto", puesto.getPuesto().getCodigo());
			parameter.addValue("vigilante", puesto.getVigilante().getCodigo());
			parameter.addValue("observacion", puesto.getObservacion());

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
	public int actualizar(String userdb, AsignacionPuesto puesto) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE carnetizacion.asignacion_puesto "
				+ "SET asp_fecha_retiro=:retiro, asp_estado=:estado "
				+ "WHERE asp_codigo=:codigo";

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("codigo", puesto.getCodigo());
			parameter.addValue("retiro", puesto.getFechaRetiro(), Types.DATE);
			parameter.addValue("estado", puesto.getEstado());

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
