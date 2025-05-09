package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {

    private Stanza stanza;
    private Stanza nord;
    private Attrezzo picozzo;
    private Attrezzo lanterna;

    @BeforeEach
    void setUp() {
        stanza   = new Stanza("Atrio");
        nord     = new Stanza("Nord");
        picozzo  = new Attrezzo("picozzo", 2);
        lanterna = new Attrezzo("lanterna", 1);
    }

    @Test
    void testGetNome() {
        assertEquals("Atrio", stanza.getNome());
    }

    @Test
    void testImpostaEGetStanzaAdiacente() {
        stanza.impostaStanzaAdiacente("nord", nord);
        assertSame(nord, stanza.getStanzaAdiacente("nord"));
        assertNull(stanza.getStanzaAdiacente("sud"));
    }

    @Test
    void testGetStanzeAdiacentiEDirezioni() {
        stanza.impostaStanzaAdiacente("nord", nord);
        stanza.impostaStanzaAdiacente("sud", new Stanza("Sud"));
        assertEquals(2, stanza.getNumeroStanzeAdiacenti());
        assertArrayEquals(new String[] {"nord", "sud"}, stanza.getDirezioni());
        assertEquals(2, stanza.getStanzeAdiacenti().length);
    }

    @Test
    void testAddHasGetRemoveAttrezzi() {
        int capacitaIniziale = stanza.getNumeroAttrezziPossibili();
        // aggiungo un attrezzo
        assertTrue(stanza.addAttrezzo(picozzo));
        // capacità diminuita di uno
        assertEquals(capacitaIniziale - 1, stanza.getNumeroAttrezziPossibili());
        // esiste ora
        assertTrue(stanza.hasAttrezzo("picozzo"));
        assertEquals(picozzo, stanza.getAttrezzo("picozzo"));
        // rimuovo
        assertTrue(stanza.removeAttrezzo(picozzo));
        assertFalse(stanza.hasAttrezzo("picozzo"));
        assertNull(stanza.getAttrezzo("picozzo"));
    }

    @Test
    void testRemoveNullOrMissingAttrezzo() {
        assertFalse(stanza.removeAttrezzo(null));
        assertFalse(stanza.removeAttrezzo(lanterna));
    }

    @Test
    void testCapacitaMassimaAttrezzi() {
        int capacita = stanza.getNumeroAttrezziPossibili();
        for (int i = 0; i < capacita; i++) {
            assertTrue(stanza.addAttrezzo(new Attrezzo("a" + i, i)));
        }
        // una aggiunta in più fallisce
        assertFalse(stanza.addAttrezzo(new Attrezzo("extra", 1)));
        assertEquals(0, stanza.getNumeroAttrezziPossibili());
    }

    @Test
    void testToStringEGetDescrizione() {
        stanza.impostaStanzaAdiacente("nord", nord);
        stanza.addAttrezzo(lanterna);
        String descrizione = stanza.toString();
        assertTrue(descrizione.contains("Atrio"));
        assertTrue(descrizione.contains("nord"));
        assertTrue(descrizione.contains("lanterna"));
        assertEquals(descrizione, stanza.getDescrizione());
    }
}

