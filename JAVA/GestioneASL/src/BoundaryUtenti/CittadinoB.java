package BoundaryUtenti;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import Control.GestoreASL;
import Exception.RegistrazioneExc;

public class CittadinoB {
	
	private static boolean CheckLengthUsername(String Username) {
		
		boolean trovato = true;
		
		if(Username.length() > 20 || Username.length() < 6) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckLengthtPassword(String Password)  {

		boolean trovato = true;
		
		if(Password.length() > 20 || Password.length() < 8) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoPassword(String Password)  {	
	
		int i = 0;
		int Upper = 0;
		int Number = 0;
		boolean trovato = true;
		
		while(i < Password.length() && (Number == 0 || Upper == 0)) {
			
			if (Character.isDigit(Password.charAt(i))) {
				
				Number++;
			}
			
			else if(Character.isUpperCase(Password.charAt(i))) {
				
				Upper++;
			}
			
			i++;
		}
		
		if(Number == 0 || Upper == 0) {
			
			trovato = false;
		}
		
		
		return trovato;
	}
	
	private static boolean  CheckLengthNome(String Nome)  {

		boolean trovato = true;
		
		if(Nome.length() > 20) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean  CheckFormatoNome(String Nome) {
		
		boolean trovato = true;
		int i = 0;
		
		while(i < Nome.length()) {
			
			if(!Character.isAlphabetic(Nome.charAt(i)) && !Character.isSpaceChar((Nome.charAt(i)))) {
				
				trovato = false;
			}	
			
			i++;
		}
		
		return trovato;
	}
	
	private static boolean  CheckLengthCognome(String Cognome)  {
		
		boolean trovato = true;
		
		if(Cognome.length() > 20) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean  CheckFormatoCognome(String Cognome) {
	
		boolean trovato = true;
		int i = 0;
		
		while(i < Cognome.length()) {
			
			if(!Character.isAlphabetic(Cognome.charAt(i)) && !Character.isSpaceChar((Cognome.charAt(i)))) {
				
				trovato = false;
			}	
			
			i++;
		}
		
		return trovato;
	}
	
	private static boolean CheckCLengthCodiceFiscale(String CodiceFiscale) {
		
		boolean trovato = true;
		
		if(CodiceFiscale.length() != 16) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoFiscale(String CodiceFiscale) {
		
	boolean okay = true;
	
	for(int i = 0; i < CodiceFiscale.length(); i++) {
		
		if((i >= 0 && i < 6) || i == 15) {
			
			if(!Character.isAlphabetic(CodiceFiscale.charAt(i))) {
				
				okay = false;
			}
			
		} else if((i >= 6 && i < 9) || (i >= 11 && i < 15)) {
			
			if(!(Character.isAlphabetic(CodiceFiscale.charAt(i)) || Character.isDigit(CodiceFiscale.charAt(i)))) {
				
				okay = false;
			}
			
		} else if(i >= 9 && i < 11) {
			
			if(!Character.isDigit(CodiceFiscale.charAt(i))) {
				
				okay = false;
			}
		} 
	}
	
	if(!okay) {
		
		okay = false;
	}
		
		return okay;
	}
	
	private static  boolean CheckLengthNumeroCellulare(String NumeroCellulare)  {
		
		boolean trovato = true;
		
		if(NumeroCellulare.length() != 10) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoNumeroCellulare(String NumeroCellulare)  {
		
		boolean trovato = true;
		int i = 0;
		
		while(i < NumeroCellulare.length()) {
			
			if(!Character.isDigit(NumeroCellulare.charAt(i))) {
				
				trovato = false;
			}
			
			i++;
		}
		
		return trovato;
	}
	
	private static boolean  CheckLengthLuogoResidenza(String LuogoResidenza)  {
		
		boolean trovato = true;
		
		if(LuogoResidenza.length() > 30) {
		
			trovato = false;	
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoLuogoResidenza(String LuogoResidenza) {
		
		int i = 0;
		boolean trovato = true;
		
		while(i < LuogoResidenza.length()) {
			
			if(!Character.isAlphabetic(LuogoResidenza.charAt(i)) && !Character.isSpaceChar((LuogoResidenza.charAt(i)))) {
				
				trovato = false;
			}	
			
			i++;
		}
		
		return trovato;
	}
	
	private static boolean  CheckLengthLuogoNascita(String LuogoNascita)  {
		
		boolean trovato = true;
		
		if(LuogoNascita.length() > 30) {
			
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoLuogoNascita(String LuogoNascita) {
		
		int i = 0;
		boolean trovato = true;
		
		while(i < LuogoNascita.length()) {
			
			if(!Character.isAlphabetic(LuogoNascita.charAt(i)) && !Character.isSpaceChar((LuogoNascita.charAt(i)))) {
			
				trovato = false;	
			}	
			
			i++;
		}
		
		return trovato;
	}
	
	private static boolean CheckLengthEmail(String Email)  {
		
		boolean trovato = true;
		
		if(Email.length() < 8) {
			
	
			trovato = false;
		}
		
		return trovato;
	}
	
	private static boolean CheckFormatoEmail(String Email) {
	
		boolean trovato = true;
		
		if(Email.contains("@") && Email.contains(".")) {
			
			int i = 0;
			int count1 = 0;
			int count2 = 0;
			
			while(i < Email.length()) {
				
				if(Email.charAt(i) == '@') {
					
					count1++;
				}
				
				if(Email.charAt(i) == '.') {
					
					count2++;
				}
				
				i++;
			}
			
			if(count1 > 1 || count2 > 1) {
				
				
				trovato = false;
			}
			
			if(!((Email.indexOf('@') + 1) < Email.indexOf('.'))) {
				
				
				trovato = false;
			}
			
		} else {
		
		
			trovato = false;
		}	
		
		return trovato;
	}
	
	private static LocalDate  CheckDataNascita(String DataNascita)  {
		
		LocalDate localDateObj;
		
		try {
			
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dateString = DataNascita;
			localDateObj = LocalDate.parse(dateString, dateTimeFormatter);
			
			} catch(DateTimeParseException e) {
		
			localDateObj = null;
		}
		
		return localDateObj;	
	}

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String Nome, Cognome, CodiceFiscale, DataNascita, LuogoNascita, LuogoResidenza, NumeroCellulare, Email, Username, Password;
		GestoreASL gASL = GestoreASL.getInstance();
		
		while(true) {
			
			System.out.println("Benvenuto");
			System.out.println("1. Registrazione");
			
			String op = scan.nextLine();
			
			if(op.equals("1")) {
				
				System.out.println("Inserisci il tuo nome");	
				Nome = scan.nextLine();
					
				System.out.println("Inserisci il tuo cognome");
				Cognome = scan.nextLine();
				
				System.out.println("Inserisci il tuo Codice Fiscale");
				CodiceFiscale = scan.nextLine().toUpperCase();
				
				System.out.println("Inserisci la tua data di nascita");
				DataNascita = scan.nextLine();
				
				System.out.println("Inserisci il tuo luogo di nascita");
				LuogoNascita = scan.nextLine();
				
				System.out.println("Inserisci il tuo luogo di residenza");
				LuogoResidenza = scan.nextLine();
				
				System.out.println("Inserisci il tuo numero di cellulare");
				NumeroCellulare = scan.nextLine();
				
				System.out.println("Inserisci la tua Email");
				Email = scan.nextLine();
				
				System.out.println("Inserisci il tuo username");
				Username = scan.nextLine();
				
				System.out.println("Inserisci la tua password");
				Password = scan.nextLine();
				
				
				boolean valido = true;
				
				 if(!CheckLengthNome(Nome)) {
					 
					 valido = false;
					 System.out.println("Errore: il Nome inserito deve avere meno di 20 caratteri");
				 }
				 
				 
				 if(!CheckFormatoNome(Nome)) {
					 
					 valido = false;
					 System.out.println("Errore: il Nome inserito contiene simboli non permessi");
				 }
				 
				 if(!CheckLengthCognome(Cognome)) {
					 
					 valido = false;
					 System.out.println("Errore: il Cognome inserito deve avere meno di 20 caratteri");
				 }
				 
				 if(!CheckFormatoCognome(Cognome)) {
					 
					 valido = false;
					 System.out.println("Errore: il Cognome inserito contiene simboli non permessi");
				 }
				 
				 
				 if(!CheckCLengthCodiceFiscale(CodiceFiscale)) {
					 
					 valido = false;
					 System.out.println("Errore: il Codice Fiscale inserito deve avere 16 caratteri");
				 }
				 
				 if(!CheckFormatoFiscale(CodiceFiscale)) {
					 
					 valido = false;
					 System.out.println("Errore: il Codice Fiscale inserito non e' nel formato standard");
				 }
				 
				 LocalDate DN = CheckDataNascita(DataNascita); 
				 
				 if(DN == null) {
					 
					 valido = false;
					 System.out.println("Errore: la data inserita deve essere nel seguente formato: gg/mm/aaaa");
				  }
				 
				 
				 if(!CheckLengthLuogoNascita(LuogoNascita)) {
					 
					 valido = false;
					 System.out.println("Errore: il luogo di nascita inserito deve avere meno di 30 caratteri");
				 }
				 
				 if(!CheckFormatoLuogoNascita(LuogoNascita)){
					 
					 valido = false;
					 System.out.println("Errore: il luogo di nascita inserito contiene simboli non permessi");
				 } 
				 
				 if(!CheckLengthLuogoResidenza(LuogoResidenza)){
			    	
			    	
			    	valido = false;
			    	System.out.println("Errore: il luogo di residenza inserito deve avere meno di 30 caratteri");
			     }
			     
				 if(!CheckFormatoLuogoResidenza(LuogoResidenza)) {
					 
					valido = false;
					System.out.println("Errore: il luogo di residenza inserito contiene simboli non permessi");
				 }
				 
				
				 if(!CheckLengthNumeroCellulare(NumeroCellulare)){
					 
					 valido = false;
			    	 System.out.println("Errore: il numero di cellulare inserito deve essere di 10 cifre");
			     }
				 
			     
			     if(!CheckFormatoNumeroCellulare(NumeroCellulare)) {
			    	 
			        valido = false;
			    	System.out.println("Errore: il numero di cellulare contiene simboli non permessi");
			    	 
			     }
			     
				 if(!CheckLengthEmail(Email)) {
					 
					 valido = false;
					 System.out.println("Errore: l'Email deve essere lunga almeno 8 caratteri");
				 }
				 
				 if(!CheckFormatoEmail(Email)){
					 
					valido = false;
					System.out.println("Errore: l'Email deve essere nel seguente formato: prova@gmail.com");
				 }
				 
				 if(!CheckLengthUsername(Username)){
					 
					 valido = false;
					 System.out.println("Errore: l'username deve avere una lunghezza compresa i 6 e i 20 caratteri"); 
				 }
				 
				 if(!CheckLengthtPassword(Password)) {
					 
					 valido = false;
					 System.out.println("Errore: la Password deve avere una lunghezza compresa gli 8 e i 30 caratteri");
				 }
				 
				 if(!CheckFormatoPassword(Password)) {
					 
					 valido = false;
					 System.out.println("Errore: la Password deve contenere almeno una cifra e un carattere maiuscolo");
				 }
				 
				try {
					
					if(valido) {
						
						if(gASL.Registrazione(Nome, Cognome, CodiceFiscale, DN, LuogoNascita, LuogoResidenza, NumeroCellulare, Email, Username, Password)) {
							
							System.out.println("Registrazione avvenuta correttamente");
							
						} else {
							
							System.out.println("Si e' verificato un errore, riprovare in seguito");
						}
							
					} else {
						
						System.out.println("Riprovare...");
					}
					
				} catch (RegistrazioneExc e) {
					
					System.out.println(e.getMessage());
				}
				
			} else {
				
				System.out.println("Operazione non disponibile");
			}
		}	
	}
}


