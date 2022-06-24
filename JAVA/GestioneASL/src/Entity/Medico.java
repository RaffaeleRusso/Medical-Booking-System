package Entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import ENUM.*;

public class Medico {

	private String Nome;
	private String Cognome;
	private LocalTime OrarioInizioServizio;
	private LocalTime OrarioFineServizio;
	private Giorno GiornoServizio;
	private Specializzazione Specializzazione;
	private String Username;
	private String Password;
	private ArrayList<Visita> VisitaRef;
	

	public void setVisitaRef(ArrayList<Visita> visitaRef) {
		
		VisitaRef = new ArrayList<Visita>(visitaRef);
		
	}

	public Medico(String nome, String cognome, LocalTime orarioInizioServizio, LocalTime orarioFineServizio,
			Giorno giornoServizio, Specializzazione specializzazione, String username, String password) {
		
		super();
		Nome = nome;
		Cognome = cognome;
		OrarioInizioServizio = orarioInizioServizio;
		OrarioFineServizio = orarioFineServizio;
		GiornoServizio = giornoServizio;
		Specializzazione = specializzazione;
		Username = username;
		Password = password;
		
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

	public LocalTime getOrarioInizioServizio() {

		return OrarioInizioServizio;
	
	}

	public void setOrarioInizioServizio(LocalTime orarioInizioServizio) {
		
		OrarioInizioServizio = orarioInizioServizio;
		
	}

	public LocalTime getOrarioFineServizio() {
		
		return OrarioFineServizio;
		
	}

	public void setOrarioFineServizio(LocalTime orarioFineServizio) {
		
		OrarioFineServizio = orarioFineServizio;
		
	}

	public Giorno getGiornoServizio() {
		
		return GiornoServizio;
		
	}

	public void setGiornoServizio(Giorno giornoServizio) {
		
		GiornoServizio = giornoServizio;
		
	}
	
	public Specializzazione getSpecializzazione() {
		
		return Specializzazione;
		
	}

	public void setSpecializzazione(Specializzazione specializzazione) {
		
		Specializzazione = specializzazione;
		
	}
	
	public String getUsername() {
		
		return Username;
		
	}
	
	public void setUsername(String username) {
		
		Username = username;
		
	}
	
	public void setPassword(String password) {
		
		Password = password;
		
	}
	
	
	public String getPassword() {
		
		return Password;
		
	}

	public boolean associaVisita(Visita v) {
		
		return VisitaRef.add(v);
		
	}
	
	public boolean rimuoviVisita(Visita v) {
		
		return VisitaRef.remove(v);
		
	}  
	
	public ArrayList<Visita> getVisite() {
		
		return VisitaRef;
		
	}
	
	
	public boolean CheckDisponibilitaVisita(LocalDate DataVisita , LocalTime OrarioVisita) {
		
		boolean trovato = false;
		int i = 0;
		
		while((i < VisitaRef.size()) && (!trovato)) {
			
			if((DataVisita.equals(VisitaRef.get(i).getDataVisita())) && (OrarioVisita.equals(VisitaRef.get(i).getOrarioVisita()))) {
				
				trovato = true;
			}
			
			i++;
		}
		
		return trovato;
	}
}
