package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

public class IOSimulatorTest {

	private final String nomeStanzaIniziale = "atrio";
	private final String nomeStanzaVincente = "biblioteca";

	@Test
	public void testPartitaVincente() {
		String[] seq = {"guarda","vai nord"};
		IO io = new IOSimulator(seq);
		Labirinto labirinto = new Labirinto();
		io.mostraMessaggio("Partita vincente"+'\n');
		DiaDia diadia = new DiaDia(labirinto, io);
		diadia.gioca();
		io.mostraMessaggio("");
	}


}