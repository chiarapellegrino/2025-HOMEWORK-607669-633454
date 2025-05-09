package it.uniroma3.diadia;

import java.util.List;

public class IOSimulator implements IO {

    private static final int CAPACITY = 100;

    private final String[] righeLette;
    private final String[] messaggiProdotti;
    private int indiceRiga = 0;
    private int indiceMessaggioScritto = 0;
    private int indiceMessaggioLetto = 0;

    public IOSimulator(String[] righeDaLeggere) {
        this.righeLette = righeDaLeggere != null
            ? righeDaLeggere.clone()
            : new String[0];
        this.messaggiProdotti = new String[CAPACITY];
    }

	@Override
    public String leggiRiga() {
        if (indiceRiga < righeLette.length) {
            return righeLette[indiceRiga++];
        }
        return null;
    }

    @Override
    public void mostraMessaggio(String msg) {
        if (indiceMessaggioScritto < messaggiProdotti.length) {
            messaggiProdotti[indiceMessaggioScritto++] = msg;
        }
    }

    public boolean hasNextMessaggio() {
        return indiceMessaggioLetto < indiceMessaggioScritto;
    }

    public String nextMessaggio() {
        if (hasNextMessaggio()) {
            return messaggiProdotti[indiceMessaggioLetto++];
        }
        return null;
    }

    public String[] getMessaggiProdotti() {
        String[] risultato = new String[indiceMessaggioScritto];
        for (int i = 0; i < indiceMessaggioScritto; i++) {
            risultato[i] = messaggiProdotti[i];
        }
        return risultato;
    }
}

