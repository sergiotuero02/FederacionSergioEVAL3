package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;

import utils.ConexBD;

public class Patrocinador {
	private long id;
	private String nombre;
	private String web;
	private double dotacion;
	public Responsable responsable;
	private Prueba[] Pruebas;

	public Patrocinador(int idPatrocinador, String nombre, double d, String web, Responsable resp) {
		this.id = idPatrocinador;
		this.nombre = nombre;
		this.dotacion = d;
		this.web = web;
		this.responsable = resp;
	}

	public Patrocinador() {
		// TODO Auto-generated constructor stub
	}

	public String mostrarBasico() {
		return nombre;

	}

	public String mostrarcompleto() {
		return nombre;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public double getDotacion() {
		return dotacion;
	}

	public void setDotacion(double dotacion) {
		this.dotacion = dotacion;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	public Prueba[] getPruebas() {
		return Pruebas;
	}

	public void setPruebas(Prueba[] pruebas) {
		Pruebas = pruebas;
	}

	@Override
	public String toString() {
		return "Patrocinador [id=" + id + ", nombre=" + nombre + ", web=" + web + ", dotacion=" + dotacion
				+ ", representante=" + responsable + ", Pruebas=" + Arrays.toString(Pruebas) + "]";
	}

	public String data() {
		return "" + this.getId() + "|" + responsable.getId() + "|" + this.getNombre() + "|" + this.getDotacion() + "|"
				+ this.getWeb();
	}

	public boolean insertarConID(Patrocinador p) {
		boolean ret = false;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr1 = "insert into responsable(id, telefonoprof, horarioini, horariofin,persona) values (?,?,?,?,?)";
		String consultaInsertStr2 = "insert into patrocinador(id, nombre, web, dotacion, responsable) values (?,?,?,?,?)";
		try {
			// insertamos el representante
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, p.responsable.getId());
			pstmt.setString(2, p.responsable.getTelefonoProf());
			Time horainiSQL = java.sql.Time.valueOf(p.responsable.getHorarioIni());
			pstmt.setTime(3, horainiSQL);
			Time horafinSQL = java.sql.Time.valueOf(p.responsable.getHorarioFin());
			pstmt.setTime(4, horafinSQL);
			pstmt.setLong(5, p.responsable.persona.getId());

			int resultadoInsercion = pstmt.executeUpdate();
			if (resultadoInsercion == 1) {
				// insertamos el patrocinador
				PreparedStatement pstmt2 = conex.prepareStatement(consultaInsertStr2);
				pstmt2.setLong(1, p.getId());
				pstmt2.setString(2, p.getNombre());
				pstmt2.setString(3, p.getNombre());
				pstmt2.setDouble(4, p.getDotacion());
				pstmt2.setLong(5, p.responsable.getId());
				int resultadoInsercion2 = pstmt2.executeUpdate();
				if (resultadoInsercion2 == 1) {
					System.out.println("Se ha insertado correctamente el nuevo Patrocinador.");
					ret = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;

	}

	public static Patrocinador nuevoPatrocinador() {
		// TODO Auto-generated method stub
		return null;
	}

}
