package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import entidades.*;
import utils.ConexBD;
import utils.Datos;

public class EquipoDAO implements operacionesCRUD<Equipo> {
	Connection conex;

	public EquipoDAO(Connection con) {
		if (this.conex == null)
			this.conex = conex;
	}

	@Override
	public boolean insetarConId(Equipo elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insetarSinId(Equipo elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Equipo buscarPorId(long elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Equipo> buscarTodos() {
		List<Equipo> todos = new ArrayList<>();
		String consultaInsertStr = "select * FROM equipos";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Equipo equipo;
				long idBD = result.getLong("id");
				long idManager = result.getLong("idmanager");
				int anioincripcion = result.getInt("anioincripcion");
				String nombre = result.getString("nombre");
				equipo = new Equipo();
				equipo.setId(idBD);
				ManagerDAO m = new ManagerDAO();
				Manager m1 = m.buscarPorId(idManager);
				equipo.setManager(m1);
				equipo.setAnioinscripcion(anioincripcion);
				equipo.setNombre(nombre);
				todos.add(equipo);
			}
			if (conex != null)
				conex.close();
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return todos;
	}

}
