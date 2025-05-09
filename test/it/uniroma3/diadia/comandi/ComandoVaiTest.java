package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

    private ComandoVai comando;
    private IOSimulator io;
    private DiaDia diadia;
    private Partita  partita;
    private Stanza stanzaCorrente;
    private Stanza stanzaNord;

    @BeforeEach
    void setUp() {
        io            = new IOSimulator(new String[] {});
        comando       = new ComandoVai();
        comando.setIo(io);
        diadia       = new DiaDia(io);
        stanzaCorrente = new Stanza("Stanza");
        stanzaNord     = new Stanza("Nord");
        partita = diadia.getPartita();
        partita.getLabirinto().setStanzaCorrente(stanzaCorrente);
    }

    @Test
    void esegui_SenzaParametro_MostraRichiestaDirezione() {
        comando.esegui(partita);
        String[] output = io.getMessaggiProdotti();
        assertEquals(1,          output.length);
        assertEquals("Per favore, indica una direzione.", output[0]);
        assertSame(stanzaCorrente, partita.getStanzaCorrente());
    }

    @Test
    void esegui_ParametroNonValido_MostraErroreDirezione() {
        comando.setParametro("nord");
        comando.esegui(partita);
        String[] output = io.getMessaggiProdotti();
        assertEquals(1,                                  output.length);
        assertEquals("Non puoi proseguire in quella direzione.", output[0]);
        assertSame(stanzaCorrente,                       partita.getStanzaCorrente());
    }

    @Test
    void esegui_ParametroValido_CambiaStanzaEModificaCfu() {
        partita.getStanzaCorrente().impostaStanzaAdiacente("nord", stanzaNord);
        comando.setParametro("nord");
        int cfuIniziali = partita.getGiocatore().getCfu();
        comando.esegui(partita);

        String[] output = io.getMessaggiProdotti();
        assertEquals(1,                       output.length);
        assertEquals("Sei entrato in: Nord",  output[0]);
        assertSame(stanzaNord,                partita.getStanzaCorrente());
        assertEquals(cfuIniziali - 1,         partita.getGiocatore().getCfu());
    }
}
