package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class ComandoFineTest {

    private ComandoFine comando;
    private IOSimulator io;
    private Partita partita;

    @BeforeEach
    void setUp() {
        comando = new ComandoFine();
        io      = new IOSimulator(new String[] {});
        comando.setIo(io);
        partita = new Partita();
    }

    @Test
    void esegui_TerminatesPartita() {
        assertFalse(partita.isFinita(), "La partita non dovrebbe essere già terminata");
        comando.esegui(partita);
        assertTrue(partita.isFinita(), "Il comando fine dovrebbe terminare la partita");
    }

    @Test
    void esegui_ShowsFarewellMessage() {
        comando.esegui(partita);
        String[] output = io.getMessaggiProdotti();
        assertEquals(1, output.length, "Dovrebbe essere stato mostrato esattamente un messaggio");
        assertEquals(ComandoFine.MESSAGGIO_FINE, output[0], "Il messaggio mostrato non corrisponde");
    }
}
