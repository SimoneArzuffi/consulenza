package it.itispaleocapa.arzuffis;

public class Funzionario extends Progetto{
    String nome;
    String cognome;
    String codice;
    int annoAssunzione;
    boolean interno; //se true riceve lo stipendio
    int costoFisso = 70;
    int numeroOreLavoro;
    int totaleStipendio;
    int annoCorrente = 2023;
    public Funzionario(String n, String c, String codice, int annoAssunzione, boolean i, int ore){
        nome = n;
        cognome = c;
        this.codice = codice;
        this.annoAssunzione = annoAssunzione;
        interno = i;
        numeroOreLavoro = ore;
    }
}
