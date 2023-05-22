package it.itispaleocapa.arzuffis;

import java.util.HashMap;
//import java.util.Iterator;
import java.util.LinkedList;

public class Progetto {
    HashMap<String, Dirigente> dirigente;
    HashMap<String, Funzionario> funzionario;
    HashMap<String, Tecnico> tecnico;
    int annoCorrente = 2023;
    public Progetto(){
        dirigente = new HashMap<>();
        funzionario = new HashMap<>();
        tecnico = new HashMap<>();
    }
    public void aggiungiDirigente(String n, String c, String codice, int annoAssunzione, boolean i, int ore)throws DipendenteGiaEsistenteException{
        if(dirigente.containsKey(codice)){
            throw new DipendenteGiaEsistenteException();
        }
        Dirigente dirigente = new Dirigente(n, c, codice, annoAssunzione, i, ore);
        this.dirigente.put(codice, dirigente);
    }
    public void aggiungiFunzionario(String n, String c, String codice, int annoAssunzione, boolean i, int ore)throws DipendenteGiaEsistenteException{
        if(dirigente.containsKey(codice)){
            throw new DipendenteGiaEsistenteException();
        }
        Funzionario funzionario = new Funzionario(n, c, codice, annoAssunzione, i, ore);
        this.funzionario.put(codice, funzionario);
    }
    public void aggiungiTecnico(String n, String c, String codice, int annoAssunzione, boolean i, boolean info, int ore)throws DipendenteGiaEsistenteException{
        if(dirigente.containsKey(codice)){
            throw new DipendenteGiaEsistenteException();
        }
        Tecnico tecnico = new Tecnico(n, c, codice, annoAssunzione, i, info, ore);
        this.tecnico.put(codice, tecnico);
    }
    public int calcolaStipendioDirigente(String codice)throws DipendenteNonEsisteException{
        int stipendio = 0;
        if(dirigente.get(codice).interno == true){
            stipendio = dirigente.get(codice).numeroOreLavoro * dirigente.get(codice).costoFisso;
        }
        return stipendio;
    }
    public int calcolaStipendioFunzionario(String codice)throws DipendenteNonEsisteException{
        int stipendio = 0;
        if(funzionario.get(codice).interno == true){
            if(annoCorrente - funzionario.get(codice).annoAssunzione < 10){
                stipendio = funzionario.get(codice).numeroOreLavoro * funzionario.get(codice).costoFisso;
            }
            else{
                stipendio = funzionario.get(codice).numeroOreLavoro * 80;
            }
        }
        return stipendio;
    }
    public int calcolaStipendioTecnico(String codice)throws DipendenteNonEsisteException{
        int stipendio = 0;
        if(tecnico.get(codice).informatico == true && tecnico.get(codice).interno == true){
            stipendio = (tecnico.get(codice).costoFissoInfo + tecnico.get(codice).numeroAnni) * tecnico.get(codice).numeroOreLavoro;
        }else{
            if(tecnico.get(codice).informatico == false && tecnico.get(codice).interno == true)
            stipendio = (tecnico.get(codice).costoFissoElettronica + tecnico.get(codice).numeroAnni) * tecnico.get(codice).numeroOreLavoro;
        }
        return stipendio;
    }
    public int calcolaTotaleStipendi()throws DipendenteNonEsisteException{
        int totale = 0;
        LinkedList<Integer> l = new LinkedList<>();
        dirigente.entrySet().stream().forEach(x -> {
            try {
                l.add(calcolaStipendioDirigente(x.getKey()));
            } catch (DipendenteNonEsisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        funzionario.entrySet().stream().forEach(x -> {
            try {
                l.add(calcolaStipendioFunzionario(x.getKey()));
            } catch (DipendenteNonEsisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        tecnico.entrySet().stream().forEach(x -> {
            try {
                l.add(calcolaStipendioTecnico(x.getKey()));
            } catch (DipendenteNonEsisteException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        for(int i = 0; i < l.size(); i++){
            totale = totale + l.get(i);
        }
        return totale;
    }
}
