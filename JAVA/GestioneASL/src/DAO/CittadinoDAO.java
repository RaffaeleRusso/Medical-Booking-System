package DAO;

import Entity.*;
import Exception.DaoExc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CittadinoDAO  {
	
	public Cittadino create(String Nome, String Cognome, String CodiceFiscale, LocalDate DataNascita, String LuogoNascita, String LuogoResidenza, String NumeroCellulare, String Email)throws DaoExc {
		
		Cittadino c = new Cittadino(Nome, Cognome, CodiceFiscale, DataNascita, LuogoNascita, LuogoResidenza, NumeroCellulare, Email);
		try {
		Connection conn = DBManager.getConnection();
	
		String query = "INSERT INTO Cittadino VALUES(?, ?, ?, ?, ?, ?, ?, ?, NULL, NULL);";
		PreparedStatement stmt = conn.prepareStatement(query);
		
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getCognome());
		stmt.setString(3, c.getCodiceFiscale());
		stmt.setDate(4, Date.valueOf(c.getDataNascita()));
		stmt.setString(5, c.getLuogoNascita());
		stmt.setString(6, c.getLuogoResidenza());
		stmt.setString(7, c.getNumeroCellulare());
		stmt.setString(8, c.getEmail());
		
		stmt.executeUpdate();
		
		}catch(SQLException e) {
				
			throw new DaoExc();
			
		}
		return c;
	}
	
	public String getEmail(String Cittadino) throws DaoExc  {
		
		String Email = new String();
		
		Connection conn;
		
		try {
			
			conn = DBManager.getConnection();
			
			
			String query = "SELECT Email FROM  Cittadino WHERE CodiceFiscale = ?;";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setString(1, Cittadino);
			ResultSet r = stmt.executeQuery();
			
			if(r.first()) {
				
				Email = r.getString(1);
			}
			
		}catch (SQLException e) {
			
			throw new DaoExc();
			
		}
		return Email;
	}
}
