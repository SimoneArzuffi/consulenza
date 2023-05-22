package it.itispaleocapa.arzuffis;


public class Tecnico extends Progetto{
    String nome;
    String cognome;
    String codice;
    int annoAssunzione;
    boolean interno; //se true riceve lo stipendio
    int costoFissoInfo = 40;
    int costoFissoElettronica = 50;
    int numeroAnni;//contatore per il numero di anni di assunzione
    int numeroOreLavoro;
    int totaleStipendio;
    int annoCorrente = 2023;
    boolean informatico = false; //se true: infromatico, se false: elettronico
    public Tecnico(String n, String c, String codice, int annoAssunzione, boolean i, boolean info, int ore){
        nome = n;
        cognome = c;
        this.codice = codice;
        this.annoAssunzione = annoAssunzione;
        interno = i;
        informatico = info;
        numeroOreLavoro = ore;
        numeroAnni = annoCorrente - annoAssunzione;
    }
}
