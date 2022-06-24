package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import Entity.*;
import Exception.DaoExc;

public class VisitaDAO {
	
	public Visita create(LocalDate DataVisita, LocalTime OrarioVisita, int NumeroStanza, int NumeroPiano, String Medico, int Prenotazione) throws DaoExc {
		
		Visita v = new Visita(DataVisita, OrarioVisita, NumeroStanza, NumeroPiano);
		try{
			
			Connection conn = DBManager.getConnection();
		
			String query = "INSERT INTO Visita VALUES(?, ?, ?, ?, ?, ?);";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setDate(1, Date.valueOf(v.getDataVisita()));
			stmt.setTime(2, Time.valueOf(v.getOrarioVisita()));
			stmt.setInt(3, v.getNumeroStanza());
			stmt.setInt(4, v.getNumeroPiano());
			stmt.setString(5, Medico);
			stmt.setInt(6, Prenotazione);
			
			stmt.executeUpdate();
			
			return v;
		
		}	catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}

	public ArrayList<Visita> read(String Medico) throws DaoExc {
	
		ArrayList<Visita> ListaVisite = new ArrayList<Visita>();
		
		try {
			
			Connection conn = DBManager.getConnection();
		
			String query = "SELECT * FROM Visita WHERE Medico = ? ;";
			PreparedStatement stmt = conn.prepareStatement(query);
				
			stmt.setString(1, Medico);
			
			ResultSet result = stmt.executeQuery();
				
			while(result.next()) {
				
				LocalDate DataVisita = result.getDate(1).toLocalDate() ;
				LocalTime OrarioVisita = result.getTime(2).toLocalTime();
				int NumeroStanza = result.getInt(3); 
				int NumeroPiano = result.getInt(4);
				
				Visita v = new Visita(DataVisita, OrarioVisita, NumeroStanza, NumeroPiano);
				ListaVisite.add(v);
				
		}
		
				return ListaVisite;
		
		}catch(SQLException e) {
			
			throw new DaoExc();
			
		}
	}
}
