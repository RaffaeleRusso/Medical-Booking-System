package BoundaryUtenti;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

import ENUM.Giorno;
import ENUM.Specializzazione;
import Control.GestoreASL;
import Control.GestoreAutenticazione;
import Exception.PrenotazioneExc;

public class CittadinoRegistratoB {
	
	private static String getGiorno(LocalDate Date) {
		
	    DayOfWeek day = Date.getDayOfWeek();
	 
	    Locale locale = Locale.ITALY; 
	
	    String Giorno = day.getDisplayName(TextStyle.FULL, locale).toUpperCase().replaceAll("ÃŒ", "I");
	    
	    Giorno = Giorno.replaceAll("Ì","I");
	    
	    return Giorno;
	    
	}
	
	private static boolean CheckSpecializzazione(String Spec) {
		
		boolean trovato = false;
		
		for(Specializzazione S: Specializzazione.values()) {
			
			if(S.name().equals(Spec.toUpperCase())) {
				
				trovato = true;
				
			}
		}
		
		return trovato;
	}
	
	private static LocalDate CheckDataVisita(String DataVisita) {
		
		LocalDate localDateObj;
		
		try {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateString = DataVisita;
			localDateObj = LocalDate.parse(dateString, dateTimeFormatter);
			
			} catch(DateTimeParseException e) {
		
			localDateObj = null;
			
		}
			return localDateObj;
	}
	
	private static LocalTime CheckOrarioVisita(String OrarioVisita)  {
		
		LocalTime localTimeObj;
		
		try {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
			String dateString = OrarioVisita;
			localTimeObj = LocalTime.parse(dateString, dateTimeFormatter);
			
			if((localTimeObj.getMinute() != 0) && (localTimeObj.getMinute() != 30)) {
				
				localTimeObj = null;
				
			}
			
		} catch(DateTimeParseException e) {
		
			localTimeObj = null;
			
		}
		
		return localTimeObj;
	}
	
	private static boolean CheckOrario_Data(LocalTime OrarioVisita, LocalDate DataVisita)  {
		
		boolean trovato = true;
		
		if((Giorno.DOMENICA).name().equals(getGiorno(DataVisita))) {
		
			trovato =  false;
			
		}
		
		if((Giorno.SABATO).name().equals(getGiorno(DataVisita))) {
			
			if(OrarioVisita.isBefore(LocalTime.of(07, 30)) || OrarioVisita.isAfter(LocalTime.of(13, 30))) {
				
				trovato =  false;
			}
			
		} else {
			
			if(OrarioVisita.isBefore(LocalTime.of(07, 30)) || OrarioVisita.isAfter(LocalTime.of(17, 30))) {
				
				trovato =  false;
			}
		}
		
		return trovato;
	}

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String DataVisita, OrarioVisita, Spec, Username, Password, CodiceFiscale;
		GestoreASL gASL = GestoreASL.getInstance();
		GestoreAutenticazione gAut = GestoreAutenticazione.getInstance();
		
		System.out.println("Benvenuto, eseguire il login");
		
		do {
			
			System.out.println("Inserisci il tuo username");
			Username = scan.nextLine();
			
			System.out.println("Inserisci la tua password");
			Password = scan.nextLine();
			
			CodiceFiscale = gAut.login(Username, Password);
			
			if(CodiceFiscale.equals("")) {
				
				System.out.println("Username e/o password non validi, riprovare");
				
			}
			
		} while(CodiceFiscale.equals(""));
		
		while(true) {
			
			System.out.println("1. PrenotaVisita");
		
			String op = scan.nextLine();
		
			if(op.equals("1")) {
				
				boolean valido = true;
				System.out.println("Inserisci la descrizione della visita tra le disponibili:");
				
				for(Specializzazione S: Specializzazione.values()) {
					
					System.out.println(S.name());
					
				}
				
				Spec = scan.nextLine();
				
				System.out.println("Inserisci la data della visita");
				DataVisita = scan.nextLine();
				
				System.out.println("Inserisci l'orario della visita");
				OrarioVisita = scan.nextLine();
				
				if(!CheckSpecializzazione(Spec)) {
					
					valido = false;
					System.out.println("Errore: hai inserito una descrizione di visita non prevista");
				} 
				
				LocalDate DV = CheckDataVisita(DataVisita); 
				 
				 if(DV == null) {
					 
					 valido = false;
					 System.out.println("Errore: hai inserito un formato data non valido");
					 
				  }
				 
				 LocalTime OV = CheckOrarioVisita(OrarioVisita); 
				 
				 if(OV == null) {
					 
					 valido = false;
					 System.out.println("Errore: l'orario inserito deve essere nel formato " + "HH:00 o HH:30" + " e definito sulle 24 ore");
					 
				  }
				 
				 if(OV != null && DV != null) {
				 
					 if(!CheckOrario_Data(OV, DV)) {
						 
						 valido = false;
						 System.out.println("Errore: orario non disponibile per il giorno inserito");
					 }
				 }
	
				try {
					
					if(valido) {
						
						if(gASL.PrenotaVisita(DV, OV, Spec, CodiceFiscale)) {
							
							System.out.println("Prenotazione confermata");
							
						} else {
							
							System.out.println("Si e' verificato un errore , riprovare in seguito");
						}
						
					} else {
						
						System.out.println("Riprovare...");
					}
					
				} catch (PrenotazioneExc e) {
					
					System.out.println(e.getMessage());
				
				}
				
			} else {
			
				System.out.println("Operazione non disponibile");
			
			}
		}	
	}
}
