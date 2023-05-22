package it.itispaleocapa.arzuffis;

public class Dirigente extends Progetto{
    String nome;
    String cognome;
    String codice;
    int annoAssunzione;
    boolean interno; //se true riceve lo stipendio
    int costoFisso = 100;
    int numeroOreLavoro;
    int totaleStipendio;
    public Dirigente(String n, String c, String codice, int annoAssunzione, boolean i, int ore){
        nome = n;
        cognome = c;
        this.codice = codice;
        this.annoAssunzione = annoAssunzione;
        interno = i;
        numeroOreLavoro = ore;
    }

    
}