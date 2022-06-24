package Entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cittadino {
	
	protected String Nome;
	protected String Cognome;
	protected String CodiceFiscale;
	protected LocalDate DataNascita;
	protected String LuogoNascita;
	protected String LuogoResidenza;
	protected String NumeroCellulare;
	protected String Email;
	protected ArrayList<Prenotazione> PrenotazioneRef;
	
	public Cittadino(String nome, String cognome, String codiceFiscale, LocalDate dataNascita, String luogoNascita,
			String luogoResidenza, String numeroCellulare, String email) {
		
		super();
		Nome = nome;
		Cognome = cognome;
		CodiceFiscale = codiceFiscale;
		DataNascita = dataNascita;
		LuogoNascita = luogoNascita;
		LuogoResidenza = luogoResidenza;
		NumeroCellulare = numeroCellulare;
		Email = email;
		
	}
	
	public boolean associaPrenotazione(Prenotazione p) {
		
		return PrenotazioneRef.add(p);
		
		}
	
	public boolean rimuoviPrenotazione(Prenotazione p) {
		
		return PrenotazioneRef.remove(p);
		
		}

	public String getNome() {
		
		return Nome;
		
	}
	
	public void setNome(String nome) {
		
		Nome = nome;
		
	}
	
	public String getCognome() {
		
		return Cognome;
		
	}
	
	public void setCognome(String cognome) {
		
		Cognome = cognome;
		
	}
	
	public String getCodiceFiscale() {
		
		return CodiceFiscale;
		
	}
	
	public void setCodiceFiscale(String codiceFiscale) {
		
		CodiceFiscale = codiceFiscale;
		
	}
	
	public LocalDate getDataNascita() {
		
		return DataNascita;
		
	}
	
	public void setDataNascita(LocalDate dataNascita) {
		
		DataNascita = dataNascita;
		
	}
	
	public String getLuogoNascita() {
		
		return LuogoNascita;
		
	}
	
	public void setLuogoNascita(String luogoNascita) {
		
		LuogoNascita = luogoNascita;
		
	}
	
	public String getLuogoResidenza() {
		
		return LuogoResidenza;
		
	}
	
	public void setLuogoResidenza(String luogoResidenza) {
		
		LuogoResidenza = luogoResidenza;
		
	}
	
	public String getNumeroCellulare() {
		
		return NumeroCellulare;
		
	}
	
	public void setNumeroCellulare(String numeroCellulare) {
		
		NumeroCellulare = numeroCellulare;
		
	}
	
	public String getEmail() {
		
		return Email;
		
	}
	
	public void setEmail(String email) {
		
		Email = email;
		
	}
}
