package it.uniroma3.diadia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {

    private Partita partita;
    private Stanza stanzaFittizia;

    @Before
    public void setUp() {
        partita = new Partita();
        stanzaFittizia = new Stanza("Stanza");
    }

    @Test
    public void getStanzaVincente_DeveRestituireBiblioteca() {
        String nomeAtteso = "Biblioteca";
        String nomeReale = partita.getLabirinto()
                                   .getStanzaVincente()
                                   .getNome();
        assertEquals(nomeAtteso, nomeReale);
    }

    @Test
    public void setStanzaCorrente_AggiornaLaStanzaNelLabirinto() {
        partita.getLabirinto().setStanzaCorrente(stanzaFittizia);
        assertEquals(stanzaFittizia, partita.getLabirinto().getStanzaCorrente());
    }

    @Test
    public void isFinita_AllInizioDiPartita_RitornaFalse() {
        assertFalse(partita.isFinita());
    }
}
