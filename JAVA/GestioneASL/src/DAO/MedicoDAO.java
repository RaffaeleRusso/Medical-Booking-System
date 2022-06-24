package DAO;

import Entity.*;
import Exception.DaoExc;
import Exception.PrenotazioneExc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import ENUM.Giorno;
import ENUM.Specializzazione;

public class MedicoDAO {
	
	public Medico create(String Nome, String Cognome, LocalTime OrarioInizioServizio, LocalTime OrarioFineServizio, Giorno GiornoServizio, Specializzazione Spec, String Username, String Password) throws DaoExc {
		
		try {
			Medico m = new Medico(Nome, Cognome, OrarioInizioServizio, OrarioFineServizio, GiornoServizio, Spec, Username, Password);
			Connection conn = DBManager.getConnection();
		
			String query = "INSERT INTO Medico VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setString(1, m.getNome());
			stmt.setString(2, m.getCognome());
			stmt.setTime(3, Time.valueOf(m.getOrarioInizioServizio()));
			stmt.setTime(4, Time.valueOf(m.getOrarioFineServizio()));
			stmt.setString(5, m.getGiornoServizio().name());
			stmt.setString(6, m.getSpecializzazione().name());
			stmt.setString(7, m.getUsername());
			stmt.setString(8, m.getPassword());
		
			stmt.executeUpdate();
			
		return m;
		
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}
	
	public Medico read(Specializzazione Spec) throws DaoExc, PrenotazioneExc {
		
		Medico m = null;
		
		try {
		Connection conn = DBManager.getConnection();
	
		String query = "SELECT * FROM Medico WHERE Specializzazione = ? ;";
		
		PreparedStatement stmt = conn.prepareStatement(query);
			
		stmt.setString(1, (Spec.name()));
		
			ResultSet result = stmt.executeQuery();
		
			if(result.first()) {
				
				String Nome = result.getString(1);
				String Cognome = result.getString(2);
				LocalTime StartTime = result.getTime(3).toLocalTime();
				LocalTime EndTime = result.getTime(4).toLocalTime();
				Giorno day  = Giorno.valueOf(result.getString(5));
				String Username = result.getString(7);
				String Password = result.getString(8);
				 m = new Medico(Nome,Cognome,StartTime,EndTime,day,Spec,Username,Password);
				 
		    } else {
				
				throw new PrenotazioneExc("Nessun medico trovato con la specializzazione : " + Spec);
			}	
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
		
		return m;
	}
}
