package it.uniroma3.diadia.attrezzi;
import java.util.Objects;

import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */
public class Attrezzo implements Comparable<Attrezzo>{

	private String nome;
	private int peso;

	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	public int getPeso() {
		return this.peso;
	}

	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}

	@Override
	public int compareTo(Attrezzo that) {
		return this.getNome().compareTo(that.getNome());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, peso);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attrezzo that = (Attrezzo) obj;
		return this.getNome().equals(that.getNome()) && this.getPeso()==that.getPeso();
	}
	
	

}