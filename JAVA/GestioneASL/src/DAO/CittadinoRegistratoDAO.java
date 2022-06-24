package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import Entity.*;
import Exception.DaoExc;
import Exception.RegistrazioneExc;

public class CittadinoRegistratoDAO {
	public CittadinoRegistrato create(String Nome, String Cognome, String CodiceFiscale, LocalDate DataNascita, String LuogoNascita, String LuogoResidenza, String NumeroCellulare, String Email, String Username, String Password) throws RegistrazioneExc, DaoExc {
		
		CittadinoRegistrato c = new CittadinoRegistrato(Nome, Cognome, CodiceFiscale, DataNascita, LuogoNascita, LuogoResidenza, NumeroCellulare, Email, Username, Password);
		
	try {
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT * FROM Cittadino WHERE CodiceFiscale = ? AND Username IS NULL";
		
		PreparedStatement stmt = conn.prepareStatement(query);
			
		stmt.setString(1, c.getCodiceFiscale());
		ResultSet R = stmt.executeQuery();
			
		if(R.first()) {
			
			update(c);
			
		} else {
			
			query = "INSERT INTO Cittadino VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement stm = conn.prepareStatement(query);
				
				stm.setString(1, c.getNome());
				stm.setString(2, c.getCognome());
				stm.setString(3, c.getCodiceFiscale());
				stm.setDate(4, Date.valueOf(c.getDataNascita()));
				stm.setString(5, c.getLuogoNascita());
				stm.setString(6, c.getLuogoResidenza());
				stm.setString(7, c.getNumeroCellulare());
				stm.setString(8, c.getEmail());
				stm.setString(9, c.getUsername());
				stm.setString(10, c.getPassword());

				stm.executeUpdate();
			}
	}catch (SQLException e) {
			
			throw new DaoExc();
			
	}
		return c;
	}
	
	public void update(CittadinoRegistrato c) throws DaoExc {
		
		try{
			
			Connection conn = DBManager.getConnection();
		
			String query = "UPDATE Cittadino SET Email = ?, Username = ?, Password = ? WHERE CodiceFiscale = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getUsername());
			stmt.setString(3, c.getPassword());
			stmt.setString(4, c.getCodiceFiscale());

			stmt.executeUpdate();
			
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}
		
	public boolean UsernameValido(String Username) throws DaoExc{
			
		try {
			
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT COUNT(*) FROM Cittadino WHERE Username = ?;";
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(query);
			
		stmt.setString(1, Username);

		ResultSet result = stmt.executeQuery();
		
		while(result.next()) {
			
			count = result.getInt(1);
			
		} 
		
		if(count == 1) {
			 
			return false;
			
		} else {
			
			return true;
			
		}
		
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
		
		
	}
	
	public boolean EmailValida(String Email) throws DaoExc {
		
		
		try {
		Connection conn = DBManager.getConnection();
		
		String query = "SELECT COUNT(*) FROM Cittadino WHERE Email = ?;";
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, Email);

		ResultSet result = stmt.executeQuery();
		
		while(result.next()) {
			
			count = result.getInt(1);
			
		}	
		
		if(count == 1) {
			 
			return false;
			
		} else {
			
			return true;
			
		}
		
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}
	
	public String readCF(String Username, String Password) throws DaoExc {

		try {
		Connection conn = DBManager.getConnection();
	
		String query = "SELECT CodiceFiscale FROM Cittadino WHERE Username = ? AND Password = ?;";
		PreparedStatement stmt = conn.prepareStatement(query);
			
		stmt.setString(1, Username);
		stmt.setString(2, Password);
		
		ResultSet result = stmt.executeQuery();
		
			if(result.first()) {
				
				String CodiceFiscale = result.getString(1);	
				return CodiceFiscale;
				
		    } 
		
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
		
		return new String("");
	
	}
	
	
	
}
