package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {

    private StanzaBloccata stanzaBloccata;
    private Stanza stanzaAdiacente;
    private Attrezzo chiave;

    @Before
    public void setUp() {
        stanzaBloccata = new StanzaBloccata("StanzaBloccata", "ovest", "grimaldello");
        stanzaAdiacente = new Stanza("Stanzetta");
        chiave         = new Attrezzo("grimaldello", 1);
        stanzaBloccata.impostaStanzaAdiacente("ovest", stanzaAdiacente);
    }

    @Test
    public void getStanzaAdiacente_DirezioneBloccata_SenzaAttrezzo_RestaStessaStanza() {
        assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("ovest"));
    }

    @Test
    public void getStanzaAdiacente_DirezioneSbloccata_ConAttrezzo_RitornaStanzaAdiacente() {
        stanzaBloccata.addAttrezzo(chiave);
        assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("ovest"));
    }

    @Test
    public void getDescrizione_DirezioneBloccata_SenzaAttrezzo_MessaggioBlocco() {
        String expected = "Stanza bloccata nella direzione: ovest\n"
                        + "Prendi il grimaldello e posalo nella stanza";
        assertEquals(expected, stanzaBloccata.getDescrizione());
    }

    @Test
    public void getDescrizione_DirezioneSbloccata_ConAttrezzo_DescrizioneStandard() {
        stanzaBloccata.addAttrezzo(chiave);
        assertEquals(stanzaBloccata.toString(), stanzaBloccata.getDescrizione());
    }
}
