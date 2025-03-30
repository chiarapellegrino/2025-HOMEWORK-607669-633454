package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.*;

import org.junit.Test;

public class LabirintoTest {
	private final Labirinto l = new Labirinto();
	private final Stanza si = new Stanza("Atrio");
	private final Stanza sd = new Stanza("aula n10");
	private final Stanza sv = new Stanza("Biblioteca");
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(si.getNome(), l.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(sv.getNome(), l.getStanzaFinale().getNome());
	}
	
	@Test
	public void testStanzaInzialeDiversoAtrio() {
		assertFalse(l.getStanzaIniziale().getNome()== sd.getNome());
	}
	
	
}

