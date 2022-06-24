package Control;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import BoundarySistemiEsterni.ServerEmailB;
import DAO.CittadinoDAO;
import DAO.CittadinoRegistratoDAO;
import DAO.MedicoDAO;
import DAO.PrenotazioneDAO;
import DAO.VisitaDAO;
import ENUM.Specializzazione;
import Entity.Medico;
import Exception.DaoExc;
import Exception.PrenotazioneExc;
import Exception.RegistrazioneExc;

public class GestoreASL {

	public static GestoreASL gA = null;

	protected GestoreASL(){
		
	}

	public static GestoreASL getInstance() { 
		
		if (gA == null) 
			gA = new GestoreASL(); 

		return gA; 
	}	
	
	private static String getGiorno(LocalDate Date) {
		
	    DayOfWeek day = Date.getDayOfWeek();
	 
	    Locale locale = Locale.ITALY; 
	
	    String Giorno = day.getDisplayName(TextStyle.FULL, locale).toUpperCase().replaceAll("ÃŒ", "I");
	    Giorno = Giorno.replaceAll("Ì","I");
	    
	    return Giorno;
	}
	
	public boolean PrenotaVisita(LocalDate DataVisita, LocalTime OrarioVisita, String Spec, String Cittadino) throws PrenotazioneExc {
						
		Specializzazione S = Specializzazione.valueOf(Spec.toUpperCase());
		MedicoDAO mDAO = new MedicoDAO();
		
		try {
			
			Medico m = mDAO.read(S);

			if(!(m.getGiornoServizio().name().equals(getGiorno(DataVisita)))  ||  OrarioVisita.isAfter(m.getOrarioFineServizio()) || OrarioVisita.isBefore(m.getOrarioInizioServizio())){
				
				throw new PrenotazioneExc("Medico indisponibile per la data e l'orario indicati");
				
			} else {
				
				VisitaDAO v = new VisitaDAO();
				
				m.setVisitaRef(v.read(m.getUsername()));
				
				if(m.CheckDisponibilitaVisita(DataVisita, OrarioVisita)) {
					
					throw new  PrenotazioneExc("Prenotazione rifiutata");
					
				} else {
					
					Random random = new Random();
					PrenotazioneDAO p = new PrenotazioneDAO();
					CittadinoDAO c = new CittadinoDAO();
					ServerEmailB SE = new ServerEmailB();
					
					p.create(p.countPrenotazioni(), LocalDate.now(), Cittadino);
					v.create(DataVisita, OrarioVisita, random.nextInt(15) + 1,  random.nextInt(3) , m.getUsername(), p.countPrenotazioni() - 1);
					String Email = c.getEmail(Cittadino);
					SE.InvioEmail(Email);
					return true;
				}	
			}
			
		} catch (DaoExc e) {
			
			return false;
		} 
	}
	
	public boolean Registrazione(String Nome, String Cognome, String CodiceFiscale, LocalDate DataNascita, String LuogoNascita, String LuogoResidenza, String NumeroCellulare, String Email, String Username, String Password) throws RegistrazioneExc {
			
		try {
			
			CheckEmail(Email);
			CheckUsername(Username);
			CittadinoRegistratoDAO crDAO = new CittadinoRegistratoDAO();
			
			crDAO.create(Nome, Cognome, CodiceFiscale, DataNascita, LuogoNascita, LuogoResidenza, NumeroCellulare, Email, Username, Password);
		
		}  catch (DaoExc e) {
			
			return false;
		}
		
		return true;
	}
	
	private static void CheckUsername(String Username) throws RegistrazioneExc, DaoExc {
		
		CittadinoRegistratoDAO cDAO =  new CittadinoRegistratoDAO();
			
		if(!cDAO.UsernameValido(Username)) {
			
			throw new RegistrazioneExc("Username gia' utilizzato");
		}
	}
		
	private static void CheckEmail(String Email) throws RegistrazioneExc,DaoExc {
		
		CittadinoRegistratoDAO cDAO =  new CittadinoRegistratoDAO();
		
		if(!cDAO.EmailValida(Email)) {
				
			throw new RegistrazioneExc("Email gia' utilizzata");
		}
	}
}




		
	


	
	
	