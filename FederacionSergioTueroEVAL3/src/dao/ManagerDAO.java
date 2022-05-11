package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import entidades.*;
import utils.ConexBD;
import utils.Datos;

public class ManagerDAO implements operacionesCRUD<Manager>{

	@Override
	public boolean insetarConId(Manager elemento) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long insetarSinId(Manager elemento) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Manager buscarPorId(long id) {
		Manager ret = null;
		Connection conex = ConexBD.establecerConexion();
		String consultaInsertStr = "select * FROM managers WHERE id=?";
		try {
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				long idPersona = result.getLong("idpersona");
				String telefono = result.getString("telefono");
				String direccion = result.getString("direccion");
				ret = new Manager();
				ret.setId(idBD);
				ret.setTelefono(telefono);
				ret.setDireccion(direccion);
				ret.setPersona(Datos.buscarPersonaPorId(idPersona));
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Se ha producido una Exception:" + e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Collection<Manager> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
