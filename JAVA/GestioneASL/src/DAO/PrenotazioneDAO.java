package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import Entity.*;
import Exception.DaoExc;

public class PrenotazioneDAO {
	
	public Prenotazione create(int IdPrenotazione, LocalDate DataPrenotazione,String Cittadino) throws DaoExc {
		
		try {
		
			Prenotazione p = new Prenotazione(IdPrenotazione, DataPrenotazione);
			Connection conn = DBManager.getConnection();
		
			String query = "INSERT INTO Prenotazione VALUES(?, ?, ?,?);";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setInt(1, p.getIdPrenotazione());
			stmt.setDate(2, Date.valueOf(p.getDataPrenotazione()));
			stmt.setString(3, p.getStato().name());
			stmt.setString(4, Cittadino);
			
			stmt.executeUpdate();
			return p;
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}
	
	public int countPrenotazioni() throws DaoExc {
		
		int count = 0;
		
		try {
			
			Connection conn = DBManager.getConnection();
		
			String query = "SELECT  COUNT(*)  FROM Prenotazione";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			ResultSet r = stmt.executeQuery();
		    
			while(r.next()) {
		        
		    	count = r.getInt(1);
		
		    }
		
			return  count;
	
		}catch(SQLException e) {
			
			throw new DaoExc();
			
	}
}
}
