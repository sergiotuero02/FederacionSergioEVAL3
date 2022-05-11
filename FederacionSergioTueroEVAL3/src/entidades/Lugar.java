package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import utils.ConexBD;

//Examen 1 Ejercicio 1
public enum Lugar implements operacionesCRUD<Lugar> {
	GIJONMESTAS(1, "Las Mestas", "Gijon", true), GIJONCENTRO(2, "Centro ciudad", "Gijon", true),
	OVIEDOSANFRANCISCO(3, "Parque San Francisco", "Oviedo", true), AVILESPUERTO(4, "Puerto", "Aviles", true),
	AVILESPABELLON(5, "Pabellon deportivo Aviles", "Aviles", false), OVIEDOCENTRO(6, "Centro ciudad", "Oviedo", true);

	private int id;
	private String nombre;
	private String ubicacion;
	private boolean airelibre;

	private Lugar(int id, String nombre, String ubicacion, boolean airelibre) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.airelibre = airelibre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public boolean isAirelibre() {
		return airelibre;
	}

	@Override
	public boolean insetarConId(Lugar l) {
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into lugares(id, nombre, ubicacion, airelibre) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setInt(1, l.getId());
			pstmt.setString(2, l.getNombre());
			pstmt.setString(3, l.getUbicacion());
			pstmt.setBoolean(4, l.isAirelibre());
			int resultadoInsercion = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public long insetarSinId(Lugar l) {
		long ret = -1;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "insert into lugares(id, nombre, ubicacion, airelibre) values (?,?,?,?)";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);

			pstmt.setString(1, l.getNombre());
			pstmt.setString(2, l.getUbicacion());
			pstmt.setBoolean(3, l.isAirelibre());
			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				String consultaSelect = "SELECT id FROM lugares WHERE(nombre=? AND ubicacion=? AND airelibre=?)";
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr);
				pstmt2.setString(1, l.getNombre());
				pstmt2.setString(2, l.getUbicacion());
				pstmt2.setInt(3, l.isAirelibre() ? 1 : 0);

				ResultSet result = pstmt2.executeQuery();
				while (result.next()) {
					long id = result.getLong("id");
					if (id != -1)
						ret = id;

				}
				result.close();
				pstmt2.close();
			}

		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Lugar buscarPorId(long idlugar) {
		Lugar ret = null;
		Connection conex = null;
		Statement consulta = null;
		ResultSet resultado = null;
		try {

			conex = ConexBD.establecerConexion();

			String consultaStr = "SELECT * FROM lugares where id" + idlugar;
			if (conex == null)
				conex = ConexBD.getCon();
			consulta = conex.createStatement();
			resultado = consulta.executeQuery(consultaStr);
			while (idlugar == resultado.getInt(1)) {

				String nombre = resultado.getString(2);
				String ubicacion = resultado.getString(3);
				boolean airelibre = resultado.getBoolean(4);

				return ret;
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una Excepcion:" + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Cerrando recursos...");
				if (resultado != null)
					resultado.close();
				if (consulta != null)
					consulta.close();
				if (conex != null)
					conex.close();
			} catch (SQLException e) {
				System.out.println("Se ha producido una Excepcion:" + e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("FIN");
		return ret;
	}

	@Override
	public Collection<Lugar> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
