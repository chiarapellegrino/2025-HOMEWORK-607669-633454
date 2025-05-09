package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza è un luogo fisico nel gioco.
 * È collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita è associata ad una direzione.
 * 
 * @author docente di POO
 * @see Attrezzo
 * @version rifattorizzata
 */
public class Stanza {

    private static final int MAX_DIREZIONI    = 4;
    private static final int MAX_ATTREZZI     = 10;


    private String     nome;
    private String[]   direzioni;
    private Stanza[]   stanzeAdiacenti;
    private Attrezzo[] attrezzi;

    private int numeroStanzeAdiacenti;
    private int numeroAttrezzi;

    public Stanza(String nome) {
        this.nome                  = nome;
        this.direzioni             = new String[MAX_DIREZIONI];
        this.stanzeAdiacenti       = new Stanza[MAX_DIREZIONI];
        this.attrezzi              = new Attrezzo[MAX_ATTREZZI];
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi        = 0;
    }



    public Stanza[] getStanzeAdiacenti() {
        Stanza[] copia = new Stanza[numeroStanzeAdiacenti];
        for (int i = 0; i < numeroStanzeAdiacenti; i++) {
            copia[i] = stanzeAdiacenti[i];
        }
        return copia;
    }

    public void setStanzeAdiacenti(Stanza[] stanze) {
    	this.numeroStanzeAdiacenti = Math.min(stanze.length, MAX_DIREZIONI);
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            this.stanzeAdiacenti[i] = stanze[i];
            this.direzioni[i]+= this.direzioni[i];
        } 
    }

    public int getNumeroStanzeAdiacenti() {
        return numeroStanzeAdiacenti;
    }

    public void setNumeroStanzeAdiacenti(int numero) {
        this.numeroStanzeAdiacenti = Math.max(0, Math.min(numero, MAX_DIREZIONI));
    }

    public void setDirezioni(String[] direzioni) {
        int lim = Math.min(direzioni.length, MAX_DIREZIONI);
        for (int i = 0; i < lim; i++) {
            this.direzioni[i] = direzioni[i];
        }
    }


    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        int idx = trovaIndiceDirezione(direzione);
        if (idx >= 0) {
         
            stanzeAdiacenti[idx] = stanza;
            return;
        }
      
        if (numeroStanzeAdiacenti < MAX_DIREZIONI) {
            direzioni[numeroStanzeAdiacenti]     = direzione;
            stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
            numeroStanzeAdiacenti++;
        }
    }

    public Stanza getStanzaAdiacente(String direzione) {
        int idx = trovaIndiceDirezione(direzione);
        if (idx >= 0) return stanzeAdiacenti[idx];
        return null;
    }

    public String[] getDirezioni() {
        String[] copia = new String[numeroStanzeAdiacenti];
        for (int i = 0; i < numeroStanzeAdiacenti; i++) {
            copia[i] = direzioni[i];
        }
        return copia;
    }

    private int trovaIndiceDirezione(String d) {
        for (int i = 0; i < numeroStanzeAdiacenti; i++) {
            if (d.equals(direzioni[i])) {
                return i;
            }
        }
        return -1;
    }

    

    public Attrezzo[] getAttrezzi() {
        Attrezzo[] copia = new Attrezzo[numeroAttrezzi];
        for (int i = 0; i < numeroAttrezzi; i++) {
            copia[i] = attrezzi[i];
        }
        return copia;
    }

    public boolean addAttrezzo(Attrezzo a) {
        if (numeroAttrezzi >= MAX_ATTREZZI) return false;
        attrezzi[numeroAttrezzi++] = a;
        return true;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return trovaIndiceAttrezzo(nomeAttrezzo) >= 0;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        int idx = trovaIndiceAttrezzo(nomeAttrezzo);
        return (idx >= 0) ? attrezzi[idx] : null;
    }

    public boolean removeAttrezzo(Attrezzo a) {
        if (a == null) return false;
        int idx = trovaIndiceAttrezzo(a.getNome());
        if (idx < 0) return false;
        for (int i = idx; i < numeroAttrezzi - 1; i++) {
            attrezzi[i] = attrezzi[i + 1];
        }
        attrezzi[--numeroAttrezzi] = null;
        return true;
    }

    private int trovaIndiceAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < numeroAttrezzi; i++) {
            if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
                return i;
            }
        }
        return -1;
    }

    public int getNumeroAttrezziPossibili() {
        return MAX_ATTREZZI - numeroAttrezzi;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome)
          .append("\nUscite:");
        for (int i = 0; i < numeroStanzeAdiacenti; i++) {
            sb.append(" ").append(direzioni[i]);
        }
        sb.append("\nAttrezzi nella stanza:");
        for (int i = 0; i < numeroAttrezzi; i++) {
            sb.append(" ").append(attrezzi[i].toString());
        }
        return sb.toString();
    }
}
