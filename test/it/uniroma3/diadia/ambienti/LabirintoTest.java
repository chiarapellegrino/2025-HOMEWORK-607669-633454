package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

    private Labirinto labirinto;
    private Stanza stanzaPersonalizzata;

    @Before
    public void setUp() {
        labirinto = new Labirinto();
        labirinto.creaStanze();
        stanzaPersonalizzata = new Stanza("DS1");
    }

    @Test
    public void getStanzaVincente_DeveRestituireBiblioteca() {
        assertEquals("Biblioteca", labirinto.getStanzaVincente().getNome());
    }

    @Test
    public void setStanzaCorrente_AggiornaLaStanzaCorrente() {
        labirinto.setStanzaCorrente(stanzaPersonalizzata);
        assertEquals(stanzaPersonalizzata, labirinto.getStanzaCorrente());
    }

    @Test
    public void getStanzaCorrente_AllInizioDiPartita_RitornaAtrio() {
        assertEquals("Atrio", labirinto.getStanzaCorrente().getNome());
    }
}


