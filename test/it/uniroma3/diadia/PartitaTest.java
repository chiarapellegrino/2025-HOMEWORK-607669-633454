package it.uniroma3.diadia;
import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;



public class PartitaTest {
	private Partita p;
    private Labirinto l;
    private Giocatore g;
    

    @Before
    public void setUp() {
        l = new Labirinto();
        p = new Partita();
        g = p.getGiocatore();
    }
	
	//Test per il metoodo isFinita
	@Test 
	public void testPartitaNonFinitaAllInizio() {
		assertFalse(p.isFinita());
	}
	
	@Test
	public void testPartitaFinitaQuandoVinta() {
		Stanza stanzaVincente = l.getStanzaFinale();
        p.setStanzaCorrente(stanzaVincente);
        assertTrue(p.isFinita());
	}
	
	@Test
    public void testPartitaFinitaQuandoZeroCfu() {
        g.setCfu(0); 
        assertTrue(p.isFinita());
    }
	//Test per il metodo getStanzaCorrenteAllInizio
	@Test
	public void testGetStanzaCorrenteAllInizio() {
		assertEquals(l.getStanzaIniziale(), p.getStanzaCorrente());
	}
	
	@Test
    public void testGetStanzaCorrenteDopoSet() {
		Stanza stanza1 = new Stanza("stanza 1");
        p.setStanzaCorrente(stanza1);
        assertEquals(stanza1, p.getStanzaCorrente());

        Stanza stanza2 = new Stanza("stanza 2");
        p.setStanzaCorrente(stanza2);
        assertEquals(stanza2, p.getStanzaCorrente());

        Stanza stanza3 = new Stanza("stanza 3");
        p.setStanzaCorrente(stanza3);
        assertEquals(stanza3, p.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteDopoSetNull() {
		p.setStanzaCorrente(null);
		assertNull(p.getStanzaCorrente());
	}
	
	@Test
	public void testGetStanzaCorrenteRestituisceStanzaVincente() {
		p.setStanzaCorrente(l.getStanzaFinale());
		assertEquals("Biblioteca", p.getStanzaCorrente().getNome());
	}
	//Test per il metodo vinta
	@Test
	public void testVintaDopoCreazione() {
	    assertFalse(p.vinta());
	}

	@Test
	public void testVintaDopoSetStanzaCorrenteNonVincente() {
		Stanza stanza1 = new Stanza("stanza 1");
	    p.setStanzaCorrente(stanza1);
	    assertFalse(p.vinta());
	}

	@Test
	public void testVintaDopoSetStanzaCorrenteVincente() {
	    p.setStanzaCorrente(l.getStanzaFinale());
	    assertTrue(p.vinta());
	}

	//Test per il metodo getGiocatore
	@Test
	public void tesGetGiocatore() {
		assertEquals(g, p.getGiocatore());
	}
	

}

