package com.usco.edu.dao.daoImpl;

import com.usco.edu.dao.IPuestoVigilanciaDao;
import com.usco.edu.entities.PuestoVigilancia;
import com.usco.edu.entities.PuestoVigilanciaTipo;
import com.usco.edu.resultSetExtractor.PuestoVigilanciaHorarioSetExtractor;
import com.usco.edu.resultSetExtractor.PuestoVigilanciaSetExtractor;
import com.usco.edu.resultSetExtractor.PuestoVigilanciaTipoSetExtractor;
import com.usco.edu.util.AuditoriaJdbcTemplate;

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

@Repository
public class PuestoVigilanciaDaoImpl implements IPuestoVigilanciaDao {
	
	@Autowired
	private AuditoriaJdbcTemplate jdbcComponent;
	
	@Autowired
	@Qualifier("JDBCTemplateConsulta")
	public JdbcTemplate jdbcTemplate;

	@Override
	public List<PuestoVigilanciaTipo> obtenerTipoPuesto(String userdb) {
		
		String sql = "select * from carnetizacion.puesto_vigilancia_tipo pvt where pvt.pvt_estado = 1";
		return jdbcTemplate.query(sql, new PuestoVigilanciaTipoSetExtractor());
		
	}
	
	
	@Override
	public List<PuestoVigilancia> obtenerPuestoVigilancia(String userdb) {
		
		String sql = "select * from carnetizacion.puesto_vigilancia pv "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo ";
		return jdbcTemplate.query(sql, new PuestoVigilanciaSetExtractor());
		
	}
	
	@Override
	public List<PuestoVigilancia> obtenerPuestoVigilanciaCodigo(int codigo, String userdb) {
		
		String sql = "select * from carnetizacion.puesto_vigilancia pv "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "where pv.puv_estado = 1 and pv.puv_codigo = " + codigo + " ";
		return jdbcTemplate.query(sql, new PuestoVigilanciaSetExtractor());
		
	}
	
	@Override
	public List<PuestoVigilancia> obtenerPuestoVigilanciaPorBloqueTipo(int subsede, int tipo, String userdb) {
		
		String sql = "select * from carnetizacion.puesto_vigilancia pv "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "where pv.puv_estado = 1 and pv.sus_codigo = " + subsede + " and pv.pvt_codigo = " + tipo +" ";
		return jdbcTemplate.query(sql, new PuestoVigilanciaSetExtractor());
		
	}
	
	@Override
	public List<PuestoVigilancia> obtenerPuestoVigilanciaPorBloqueTipoSinHorarioCompleto(int subsede, int tipo, String userdb) {
		
		String sql = "select pv.puv_codigo, pv.puv_nombre, pv.sed_codigo, pv.sus_codigo, pv.blo_codigo, pv.puv_fecha_creacion, pv.puv_fecha_cierre, pv.puv_cupo_carro, pv.puv_cupo_moto, pv.puv_cupo_bicicleta, pv.puv_cupo_vigilante, pv.puv_estado, pv.pvt_codigo, s.sed_codigo, s.sed_nombre, s.mun_codigo, s.sippa_sed_codigo, s.sed_estado, s.SedNombre_corto, ss.sus_codigo, ss.sus_nombre, ss.sed_codigo, ss.sus_direccion, ss.sus_telefono, ss.sippa_sedcodigo, ss.sus_estado, b.blo_codigo, b.blo_nombre, b.sus_codigo, b.sippa_blocodigo, b.blo_latitud, b.blo_longitud, b.blo_estado, pvt.pvt_codigo, pvt.pvt_nombre, pvt.pvt_estado from carnetizacion.puesto_vigilancia pv "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "left join carnetizacion.horario_puesto_vigilancia hpv on pv.puv_codigo = hpv.puv_codigo "
				+ "where pv.puv_estado = 1 and pv.sus_codigo = " + subsede + " and pv.pvt_codigo = " + tipo + " "
				+ "group by pv.puv_codigo, pv.puv_nombre, pv.sed_codigo, pv.sus_codigo, pv.blo_codigo, pv.puv_fecha_creacion, pv.puv_fecha_cierre, pv.puv_cupo_carro, pv.puv_cupo_moto, pv.puv_cupo_bicicleta, pv.puv_cupo_vigilante, pv.puv_estado, pv.pvt_codigo, s.sed_codigo, s.sed_nombre, s.mun_codigo, s.sippa_sed_codigo, s.sed_estado, s.SedNombre_corto, ss.sus_codigo, ss.sus_nombre, ss.sed_codigo, ss.sus_direccion, ss.sus_telefono, ss.sippa_sedcodigo, ss.sus_estado, b.blo_codigo, b.blo_nombre, b.sus_codigo, b.sippa_blocodigo, b.blo_latitud, b.blo_longitud, b.blo_estado, pvt.pvt_codigo, pvt.pvt_nombre, pvt.pvt_estado "
				+ "HAVING COUNT(*) < 7;";
		return jdbcTemplate.query(sql, new PuestoVigilanciaSetExtractor());
		
	}
	
	@Override
	public List<PuestoVigilancia> obtenerPuestoVigilanciaPorBloqueTipoHorario(int subsede, int tipo, String userdb) {
		String sql = "select pv.puv_codigo, pv.puv_nombre, pv.puv_cupo_vigilante, pv.puv_estado from carnetizacion.puesto_vigilancia pv "
				+ "inner join sede s on pv.sed_codigo = s.sed_codigo "
				+ "inner join sub_sede ss on pv.sus_codigo = ss.sus_codigo "
				+ "inner join bloque b on pv.blo_codigo = b.blo_codigo "
				+ "inner join carnetizacion.puesto_vigilancia_tipo pvt on pv.pvt_codigo = pvt.pvt_codigo "
				+ "inner join carnetizacion.horario_puesto_vigilancia hpv on pv.puv_codigo = hpv.puv_codigo "
				+ "where pv.puv_estado = 1 and pv.sus_codigo = " + subsede + " and pv.pvt_codigo = " + tipo + " and NOT EXISTS ( SELECT * FROM carnetizacion.asignacion_puesto ap WHERE pv.puv_codigo = ap.puv_codigo ) "
				+ "group by pv.puv_codigo, pv.puv_nombre, pv.puv_cupo_vigilante, pv.puv_estado ";
		return jdbcTemplate.query(sql, new PuestoVigilanciaHorarioSetExtractor());
	}

	@Override
	public int registrar(String userdb, PuestoVigilancia puestoVigilancia) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO carnetizacion.puesto_vigilancia "
				+ "(puv_nombre, sed_codigo, sus_codigo, blo_codigo, puv_cupo_vigilante, puv_cupo_carro, puv_cupo_moto, puv_cupo_bicicleta, pvt_codigo) "
				+ "VALUES(:nombre, :sedeCodigo, :subsedeCodigo, :bloqueCodigo, :cupoVigilante, :cupoCarro, :cupoMoto, :cupoBicicleta, :tipoPuesto);";
		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("nombre", puestoVigilancia.getNombre());
			parameter.addValue("sedeCodigo", puestoVigilancia.getSede().getCodigo());
			parameter.addValue("subsedeCodigo", puestoVigilancia.getSubsede().getCodigo());
			parameter.addValue("bloqueCodigo", puestoVigilancia.getBloque().getCodigo());
			parameter.addValue("cupoVigilante", puestoVigilancia.getCupoVigilante());
			parameter.addValue("cupoCarro", puestoVigilancia.getCupoCarro());
			parameter.addValue("cupoMoto", puestoVigilancia.getCupoMoto());
			parameter.addValue("cupoBicicleta", puestoVigilancia.getCupoBicicleta());
			parameter.addValue("tipoPuesto", puestoVigilancia.getTipoPuesto().getCodigo());

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
	public int actualizar(String userdb, PuestoVigilancia puestoVigilancia) {
		
		DataSource dataSource = jdbcComponent.construirDataSourceDeUsuario(userdb);
		NamedParameterJdbcTemplate jdbc = jdbcComponent.construirTemplatenew(dataSource);

		String sql = "UPDATE carnetizacion.puesto_vigilancia "
				+ "SET puv_nombre=:nombre, sed_codigo=:sedeCodigo, sus_codigo=:subsedeCodigo, blo_codigo=:bloqueCodigo, "
				+ "puv_fecha_cierre=:fechaCierre, puv_cupo_vigilante=:cupoVigilante, puv_cupo_carro=:cupoCarro, puv_cupo_moto=:cupoMoto, puv_cupo_bicicleta=:cupoBicicleta, "
				+ "puv_estado=:estado, pvt_codigo=:tipoPuesto "
				+ "WHERE puv_codigo=:codigo";

		try {

			MapSqlParameterSource parameter = new MapSqlParameterSource();
			
			parameter.addValue("codigo", puestoVigilancia.getCodigo());
			parameter.addValue("nombre", puestoVigilancia.getNombre());
			parameter.addValue("sedeCodigo", puestoVigilancia.getSede().getCodigo());
			parameter.addValue("subsedeCodigo", puestoVigilancia.getSubsede().getCodigo());
			parameter.addValue("bloqueCodigo", puestoVigilancia.getBloque().getCodigo());
			parameter.addValue("fechaCierre", puestoVigilancia.getFechaCierre(), Types.DATE);
			parameter.addValue("cupoVigilante", puestoVigilancia.getCupoVigilante());
			parameter.addValue("cupoCarro", puestoVigilancia.getCupoCarro());
			parameter.addValue("cupoMoto", puestoVigilancia.getCupoMoto());
			parameter.addValue("cupoBicicleta", puestoVigilancia.getCupoBicicleta());
			parameter.addValue("estado", puestoVigilancia.getEstado());
			parameter.addValue("tipoPuesto", puestoVigilancia.getTipoPuesto().getCodigo());

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
