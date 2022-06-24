package Entity;

import java.time.LocalDate;
import ENUM.*;

public class Prenotazione {
	
	private int IdPrenotazione;
	private LocalDate DataPrenotazione;
	private STATO Stato;
	private Visita VisitaRef;
	private Cittadino CittadinoRef;
	
	public Prenotazione(int idPrenotazione, LocalDate dataPrenotazione) {
		
		super();
		IdPrenotazione = idPrenotazione;
		DataPrenotazione = dataPrenotazione;
		Stato = STATO.CONFERMATA;
		
	}
	
	public void  associaVisita(Visita v) {
	 
		this.VisitaRef = v;
		
	}
 
	public void rimuoviVisita() {
		
		this.VisitaRef = null;
	 
	}
 
	public Visita getVisita() {
		
		return VisitaRef;
		
	}
 
	
	 public Visita getVisitaFutura() {
		 
		 if(VisitaRef.getDataVisita().isAfter(LocalDate.now())) {
			 
			 return VisitaRef;
			 
		 } else {
			 
			 return null;
			 
		 } 
	 }
	
	
	public STATO getStato() {
		
		return Stato;
		
	}

	public void setStato(STATO stato) {
		
		Stato = stato;
		
	}

	public int getIdPrenotazione() {
		
		return IdPrenotazione;
		
	}
	
	public void setIdPrenotazione(int idPrenotazione) {
		
		IdPrenotazione = idPrenotazione;
		
	}
	
	public LocalDate getDataPrenotazione() {
		
		return DataPrenotazione;
		
	}
	
	public void setDataPrenotazione(LocalDate dataPrenotazione) {
		
		DataPrenotazione = dataPrenotazione;
		
	}
	
	public void associaCittadino(Cittadino c) {
		
		this.CittadinoRef = c;
		
	}
	
	public void rimuoviCittadino() {
		
		this.CittadinoRef = null;
		
	}
}
