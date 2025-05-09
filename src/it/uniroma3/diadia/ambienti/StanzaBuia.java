package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

    private String attrezzoLucente;

 
    public StanzaBuia(String nome, String attrezzoLucente) {
        super(nome);
        this.attrezzoLucente = attrezzoLucente;
    }


    @Override
    public String getDescrizione() {
        if (!hasAttrezzo(attrezzoLucente)) {
            return "qui c'è un buio pesto";
        }
        return super.getDescrizione();
    }
}
