package Entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Visita {
	
	private LocalDate DataVisita;
	private LocalTime OrarioVisita;
	private int NumeroStanza;
	private int NumeroPiano;
	private Medico MedicoRef;
	private Prenotazione PrenotazioneRef;
	
	public Visita(LocalDate dataVisita, LocalTime orarioVisita, int numeroStanza, int numeroPiano) {
		
		super();
		DataVisita = dataVisita;
		OrarioVisita = orarioVisita;
		NumeroStanza = numeroStanza;
		NumeroPiano = numeroPiano;
		
	}

	public void  associaMedico(Medico m) {
		
		this.MedicoRef = m;
		
	}
	
	public void rimuoviMedico() {
		
		this.MedicoRef = null;
		
	}
	
	public LocalDate getDataVisita() {
		
		return DataVisita;
		
	}
	
	public void setDataVisita(LocalDate dataVisita) {
		
		DataVisita = dataVisita;
		
	}

	public LocalTime getOrarioVisita() {
		
		return OrarioVisita;
		
	}
	
	public void setOrarioVisita(LocalTime orarioVisita) {
		
		OrarioVisita = orarioVisita;
		
	}

	public int getNumeroStanza() {
		
		return NumeroStanza;
		
	}

	public void setNumeroStanza(int numeroStanza) {
		
		NumeroStanza = numeroStanza;
		
	}

	public int getNumeroPiano() {
		
		return NumeroPiano;
	}

	
	public void setNumeroPiano(int numeroPiano) {
		
		NumeroPiano = numeroPiano;
		
	}
	
	public void associaPrenotazione(Prenotazione p) {
		
		this.PrenotazioneRef = p;
		
	}
	
	public void rimuoviPrenotazione() {
		
		this.PrenotazioneRef = null;
		
	}
	
	public Prenotazione getPrenotazione() {
		
		return PrenotazioneRef;
		
	}
}
