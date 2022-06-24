
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import DAO.DBManager;

public class InizializzaDB {
	public static void main(String[] args) throws SQLException {
		
		try {
			
			Connection conn = DBManager.getConnection();
			String query;
			
			query = "CREATE TABLE Medico("
					+" Nome VARCHAR(30),"
					+" Cognome VARCHAR(30),"
					+" OrarioInizioServizio TIME,"
					+" OrarioFineServizio TIME,"
					+" GiornoServizio VARCHAR(20),"
					+" Specializzazione VARCHAR(25),"
					+" Username VARCHAR(30),"
					+" Password VARCHAR(30)"
					+");";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
				
			} catch(SQLException e) {
				
				System.out.println("Tabella medico gia creata");
			}
			
			query = "CREATE TABLE Prenotazione("
					+" IdPrenotazione INT PRIMARY KEY,"
					+" DataPrenotazione DATE,"
					+" Stato VARCHAR(15),"
					+" Cittadino CHAR(16)"
					+");";
			
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
				
				stmt.executeUpdate();
				
			} catch(SQLException e) {
				
				System.out.println("Tabella prenotazione gia creata");
			}
			
			query = "CREATE TABLE Visita("
					+" DataVisita DATE,"
					+" OrarioVisita TIME,"
					+" NumeroStanza INT ,"
					+" NumeroPiano INT,"
					+" Medico VARCHAR(30),"
					+" Prenotazione INT,"
					+" PRIMARY KEY(DataVisita,OrarioVisita,NumeroStanza,NumeroPiano)"
					+");";
				
			try(PreparedStatement stmt = conn.prepareStatement(query)) {
					
				stmt.executeUpdate();
					
			} catch(SQLException e) {
					
				System.out.println("Tabella visita gia creata");
			}
		
			query = "CREATE TABLE Cittadino("
					+" Nome VARCHAR(20),"
					+" Cognome VARCHAR(20),"
					+" CodiceFiscale CHAR(16) UNIQUE,"
					+" DataNascita DATE,"
					+" LuogoNascita VARCHAR(30),"
					+" LuogoResidenza VARCHAR(30),"
					+" NumeroCellulare CHAR(10),"
					+" Email VARCHAR(50) PRIMARY KEY,"
					+" Username VARCHAR(20) DEFAULT NULL UNIQUE,"
					+" Password VARCHAR(30) DEFAULT NULL"
					+");";
		
		
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
			
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("Tabella cittadino gia creata");
			
		}	
		
		query =  " alter table Visita add foreign key(Medico) references Medico(Username);"
				+" alter table Visita add foreign key(Prenotazione) references Prenotazione(IdPrenotazione);"
				+" alter table Prenotazione add foreign key(Cittadino) references Cittadino(CodiceFiscale);";
	
		try(PreparedStatement stmt = conn.prepareStatement(query)) {
	
			stmt.executeUpdate();
			
		} catch(SQLException e) {
			
			System.out.println("Vincoli errati");
		}	
 
	} catch (SQLException e) {
		
		System.out.println("DB non inizializzato correttamente");
		
	} finally {
		
		DBManager.closeConnection();
	}
  }
}
	
		

