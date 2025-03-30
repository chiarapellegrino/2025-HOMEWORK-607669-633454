package it.uniroma3.diadia.giocatore;
import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.*;


public class BorsaTest {
	
	private final Attrezzo c = new Attrezzo("calcolatrice", 2);
	private final Borsa b = new Borsa();
	private final Attrezzo ascia = new Attrezzo("ascia", 5);
	private final Attrezzo lancia = new Attrezzo("lancia", 12);
	
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(c));
	}
	
	@Test
	public void testAddAttrezzoNull() {
		assertFalse(b.addAttrezzo(null));
	}
	
	@Test
	public void testAddAttrezzoDiversoNull() {
		assertNotNull(b.addAttrezzo(c));
	}
	
	@Test
	public void testGetPesoMax() {
		assertFalse(b.getPesoMax()== 5);		
	}
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(ascia));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(lancia));
	}

}
