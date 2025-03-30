package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;

	private boolean finita;
	private Stanza stanzaCorrente;
	private Labirinto l;
	private Giocatore player;
	
	public Partita(){
		this.finita = false;
		this.l=new Labirinto();
		this.player=new Giocatore();
		this.player.setCfu(CFU_INIZIALI);
		this.stanzaCorrente=l.getStanzaIniziale();
	}

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
  


	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	

	
	public Giocatore getGiocatore() {
		return this.player;
	};
	 
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente().equals(this.l.getStanzaFinale());
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.player.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}


}
