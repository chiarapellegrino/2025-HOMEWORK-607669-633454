package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;

class ComandoAiutoTest {

    private ComandoAiuto comando;
    private IOSimulator io;

    @BeforeEach
    void setUp() {
        comando = new ComandoAiuto();
        io = new IOSimulator(new String[] {});
        comando.setIo(io);
    }

    @Test
    void esegui_DovrebbeStampareElencoComandiEPoiRigaVuota() {
        comando.esegui(new Partita());

        String[] expected = new String[ComandoAiuto.ELENCO_COMANDI.length + 1];
        for (int i = 0; i < ComandoAiuto.ELENCO_COMANDI.length; i++) {
            expected[i] = ComandoAiuto.ELENCO_COMANDI[i] + " ";
        }
        expected[ComandoAiuto.ELENCO_COMANDI.length] = "";

        assertArrayEquals(expected, io.getMessaggiProdotti());
    }
}
