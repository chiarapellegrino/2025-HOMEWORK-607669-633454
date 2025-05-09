package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoVai implements Comando {

    private String direzione;
    private IO io;
    private static final String NOME = "vai";

    @Override
    public void esegui(Partita partita) {
        Stanza stanzaCorrente = partita.getStanzaCorrente();
        if (direzione == null) {
            io.mostraMessaggio("Per favore, indica una direzione.");
            return;
        }
        Stanza prossimaStanza = stanzaCorrente.getStanzaAdiacente(direzione);
        if (prossimaStanza == null) {
            io.mostraMessaggio("Non puoi proseguire in quella direzione.");
            return;
        }
        partita.setStanzaCorrente(prossimaStanza);
        io.mostraMessaggio("Sei entrato in: " + partita.getStanzaCorrente().getNome());
        Giocatore giocatore = partita.getGiocatore();
        giocatore.setCfu(giocatore.getCfu() - 1);
    }

    @Override
    public void setParametro(String parametro) {
        this.direzione = parametro;
    }

    @Override
    public String getParametro() {
        return direzione;
    }

    @Override
    public void setIo(IO io) {
        this.io = io;
    }

    @Override
    public String getNome() {
        return NOME;
    }
}

