

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import DAO.CittadinoRegistratoDAO;
import DAO.MedicoDAO;
import ENUM.Giorno;
import ENUM.Specializzazione;
import Exception.DaoExc;
import Exception.RegistrazioneExc;

public class PopolamentoDB {
	
	public static void main(String [] args) {
	
		CittadinoRegistratoDAO c = new CittadinoRegistratoDAO();
		MedicoDAO m = new MedicoDAO();
	
		try {
		
			c.create("Alessandro", "Vanacore", "VNCASN99D17B026Q", LocalDate.of(1999, Month.APRIL, 21), "Vico Equense", "Sorrento", "3387645891", "alessandro.vanacore@gmail.com", "Username", "Password1");
			m.create("Raffaele", "Russo", LocalTime.of(7, 30), LocalTime.of(13, 30), Giorno.SABATO, Specializzazione.NEUROLOGIA, "Raffaele", "RaffRusso1");
			m.create("Giuseppe", "Gargiulo", LocalTime.of(7, 30), LocalTime.of(16, 30), Giorno.MARTEDI, Specializzazione.CARDIOLOGIA, "PeppeGarg", "PeppeGarg1");
			
		} catch (DaoExc e) {
			
			System.out.println("Errore nel popolamento del DB");

		} catch (RegistrazioneExc e) {
			
			System.out.println(e.getMessage());
		} 
	}
}
