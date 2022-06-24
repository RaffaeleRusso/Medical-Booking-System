package Entity;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.junit.Test;

import ENUM.Giorno;
import ENUM.Specializzazione;

public class MedicoTest {

		@Test
		public void testSetVisitaRef() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Visita V = new Visita(LocalDate.of(2021, 4, 17),LocalTime.of(10,30),1,1);
			ArrayList<Visita> visitaRef = new ArrayList<Visita>();
			visitaRef.add(V);
			M.setVisitaRef(visitaRef);
			assertEquals(visitaRef,M.getVisite());
			assertEquals(visitaRef.get(0),M.getVisite().get(0));
		}
	
		@Test
		public void testCheckDisponibilitaVisita() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Visita V = new Visita(LocalDate.of(2021, 4, 17),LocalTime.of(10,30),1,1);
			ArrayList<Visita> visitaRef = new ArrayList<Visita>();
			visitaRef.add(V);
			M.setVisitaRef(visitaRef);
			boolean check = M.CheckDisponibilitaVisita(LocalDate.of(2021, 4, 17),LocalTime.of(10, 30));
			assertTrue(check);
		}
	
	

		@Test
		public void testAssociaVisita() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Visita V = new Visita(LocalDate.of(2021, 4, 17),LocalTime.of(10,30),1,1);
			ArrayList<Visita> visitaRef = new ArrayList<Visita>();
			M.setVisitaRef(visitaRef);
			boolean check = M.associaVisita(V);
			assertTrue(check);
			assertEquals(1,M.getVisite().size());
			
		}
	
		@Test
		public void testRimuoviVisita() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Visita V = new Visita(LocalDate.of(2021, 4, 17),LocalTime.of(10,30),1,1);
			ArrayList<Visita> visitaRef = new ArrayList<Visita>();
			visitaRef.add(V);
			M.setVisitaRef(visitaRef);
			assertEquals(1,M.getVisite().size());
			boolean check = M.rimuoviVisita(V);
			assertTrue(check);
			assertEquals(0,M.getVisite().size());
		}
	
		@Test
		public void testGetVisite() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			ArrayList<Visita> visitaRef = new ArrayList<Visita>();
			M.setVisitaRef(visitaRef);
			assertEquals(visitaRef,M.getVisite());
			
		}
	

		@Test
		public void testGetNome() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			String Nome = M.getNome();
			assertEquals("Raffaele",Nome);
		}
		
		@Test
		public void testGetCognome() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			String Cognome = M.getCognome();
			assertEquals("Russo",Cognome);
		}
		
		@Test
		public void testGetOrarioInizioServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			LocalTime OI = M.getOrarioInizioServizio();
			assertEquals(LocalTime.of(07,30),OI);
		}
		
		@Test
		public void testGetOrarioFineServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			LocalTime OI = M.getOrarioFineServizio();
			assertEquals(LocalTime.of(13, 30),OI);	
		}
		
		@Test
		public void testGetSpecializzazione() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Specializzazione S =  M.getSpecializzazione();
			assertEquals(Specializzazione.NEUROLOGIA,S);
		}
		
		@Test
		public void testGetUsername() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			String Username =  M.getUsername();
			assertEquals("Raff",Username);
		}
		
		@Test
		public void testGetPassword() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			String Password =  M.getPassword();
			assertEquals("Password1",Password);
		}
		
		
		@Test
		public void testSetNome() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			M.setNome("Peppe");
			assertEquals("Peppe",M.getNome());
		}
		
		@Test
		public void testSetCognome() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			M.setCognome("Cast");
			assertEquals("Cast",M.getCognome());
		}
		
		@Test
		public void testSetOrarioInizioServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			M.setOrarioInizioServizio(LocalTime.of(8, 30));
			assertEquals(LocalTime.of(8,30),M.getOrarioInizioServizio());
		}
		
		@Test
		public void testSetOrarioFineServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
		    M.setOrarioFineServizio(LocalTime.of(8, 30));
			assertEquals(LocalTime.of(8,30),M.getOrarioFineServizio());	
		}
		
		@Test
		public void testSetSpecializzazione() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
		    M.setSpecializzazione(Specializzazione.CARDIOLOGIA);
			assertEquals(Specializzazione.CARDIOLOGIA,M.getSpecializzazione());
		}
		
		@Test
		public void testSetUsername() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			M.setUsername("Raff99");
			assertEquals("Raff99",M.getUsername());
		}
		
		@Test
		public void testSetPassword() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
		    M.setPassword("Password2");
			assertEquals("Password2",M.getPassword());
		}
		
		@Test
		public void testgetGiornoServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			Giorno giorno = M.getGiornoServizio();
			assertEquals(Giorno.LUNEDI,giorno);
		}

		@Test
		public void testsetGiornoServizio() {
			Medico M = new Medico("Raffaele","Russo",LocalTime.of(07, 30),LocalTime.of(13, 30),Giorno.LUNEDI,Specializzazione.NEUROLOGIA,"Raff","Password1");
			M.setGiornoServizio(Giorno.MARTEDI);
			assertEquals(Giorno.MARTEDI, M.getGiornoServizio());
			
		}
		
		
		
}
	


