package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import entidades.*;
import utils.*;

public class ParticipanteDAO implements operacionesCRUD<Participante>{

	Connection conex;

	public void ParticianteDAO(Connection conex) {
		if (this.conex == null)
			this.conex = conex;
	}
	@Override
	public boolean insetarConId(Participante p) {
		boolean ret = false;

		String consultaInsertStr1 = "insert into participantes(id, dorsal, calle, penalizacion, otros) values (?,?,?,?,?)";
	
		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.establecerConexion();
				}
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setLong(1, p.getId());
			pstmt.setInt(2, p.getDorsal());
			pstmt.setString(3, String.valueOf(p.getCalle()));			
			pstmt.setBoolean(4, p.isPenalizacion());
			pstmt.setString(2, p.getOtros());
			int resultadoInsercion = pstmt.executeUpdate();
			ret = true;
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return false;
		}

		return ret;
	}

	@Override
	public long insetarSinId(Participante p) {
		
		String consultaInsertStr1 = "insert into participantes(dorsal, calle, penalizacion, otros) values (?,?,?,?)";
		
		try {
			if (this.conex == null || this.conex.isClosed()) {
				this.conex = ConexBD.establecerConexion();
				}
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr1);
			pstmt.setInt(2, p.getDorsal());
			pstmt.setString(3, String.valueOf(p.getCalle()));			
			pstmt.setBoolean(4, p.isPenalizacion());
			pstmt.setString(2, p.getOtros());
			int resultadoInsercion = pstmt.executeUpdate();
			ResultSet result = pstmt.executeQuery();
			long idparticipante = result.getLong("id");
			return idparticipante;
		} catch (SQLException e) {
			System.out.println("Se ha producido una SQLException:" + e.getMessage());
			e.printStackTrace();
			return -1;
		}
		
	}

	@Override
	public Participante buscarPorId(long id) {
		Participante ret = null;
		String consultaInsertStr = "select * FROM participantes WHERE id=?";
		try {
			if (this.conex == null || this.conex.isClosed())
				this.conex = ConexBD.establecerConexion();
			PreparedStatement pstmt = conex.prepareStatement(consultaInsertStr);
			pstmt.setLong(1, id);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				long idBD = result.getLong("id");
				int dorsal = result.getInt("dorsal");
				String calle = result.getString("calle");
				boolean penalizacion = result.getBoolean("penalizacion");
				String otros = result.getString("otros");
				ret = new Participante();
				ret.setId(idBD);
				ret.setDorsal(dorsal);
				ret.setCalle(calle.charAt(0));
				ret.setPenalizacion(penalizacion);
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
		return ret;
	}
	@Override
	public Collection<Participante> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
