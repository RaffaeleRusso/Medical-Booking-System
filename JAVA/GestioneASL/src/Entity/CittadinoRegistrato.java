package Entity;

import java.time.LocalDate;
import ENUM.STATO;
import java.util.ArrayList;

public class CittadinoRegistrato extends Cittadino {
	
	public CittadinoRegistrato(String nome, String cognome, String codiceFiscale, LocalDate dataNascita,
			String luogoNascita, String luogoResidenza, String numeroCellulare, String email, String username,
			String password) {
		
		super(nome, cognome, codiceFiscale, dataNascita, luogoNascita, luogoResidenza, numeroCellulare, email);
		Username = username;
		Password = password;
	}
	
	public ArrayList<Prenotazione> getPrenotazioniConfermate(){
		
		ArrayList<Prenotazione> temp = new ArrayList<Prenotazione>();
		
		for(int i = 0; i < PrenotazioneRef.size(); i++) {
			
			if(PrenotazioneRef.get(i).getStato() == STATO.CONFERMATA) {
				
				temp.add(PrenotazioneRef.get(i));
			}
		}
		
		return temp;
	}

	private String Username;
	private String Password;
	
	public String getUsername() {
		
		return Username;
		
	}
	
	public String getPassword() {
		
		return Password;
		
	}

	public void setUsername(String username) {
		
		Username = username;
		
	}
	
	public void setPassword(String password) {
		
		Password = password;
		
	}
}
