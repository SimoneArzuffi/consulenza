package it.itispaleocapa.arzuffis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private Progetto progetto;

    @BeforeEach
    public void setUp() {
        progetto = new Progetto();
    }
    @Test
    public void testAggiungiDirigente() throws DipendenteGiaEsistenteException{
        progetto.aggiungiDirigente("Simone", "Arzuffi", "COD001", 2020, true, 40);

        // Verifica che il dirigente sia stato aggiunto correttamente
        Assertions.assertTrue(progetto.dirigente.containsKey("COD001"));
    }
    @Test
    public void testAggiungiFunzionario() throws DipendenteGiaEsistenteException{
        progetto.aggiungiFunzionario("Mario", "Rossi", "COD002", 2019, true, 40);

        // Verifica che il funzionario sia stato aggiunto correttamente
        Assertions.assertTrue(progetto.funzionario.containsKey("COD002"));
    }
    @Test
    public void testAggiungiTecnico() throws DipendenteGiaEsistenteException{
        progetto.aggiungiTecnico("Giuseppe", "Verdi", "COD003", 2021, true, false, 40);

        // Verifica che il tecnico sia stato aggiunto correttamente
        Assertions.assertTrue(progetto.tecnico.containsKey("COD003"));
    }
    @Test
    public void testCalcolaStipendioDirigente() throws DipendenteGiaEsistenteException, DipendenteNonEsisteException{
        progetto.aggiungiDirigente("Simone", "Arzuffi", "COD001", 2020, true, 40);

        // Verifica il calcolo dello stipendio per un dirigente interno
        int stipendio = progetto.calcolaStipendioDirigente("COD001");
        Assertions.assertEquals(4000, stipendio);
    }
    @Test
    public void testCalcolaStipendioFunzionario() throws DipendenteGiaEsistenteException, DipendenteNonEsisteException{
        progetto.aggiungiFunzionario("Mario", "Rossi", "COD002", 2014, true, 40);

        // Verifica il calcolo dello stipendio per un funzionario interno con meno di 10 anni di servizio
        int stipendio1 = progetto.calcolaStipendioFunzionario("COD002");
        Assertions.assertEquals(2800, stipendio1);

        progetto.aggiungiFunzionario("Marta", "Gialli", "COD003", 2000, true, 40);

        // Verifica il calcolo dello stipendio per un funzionario interno con più di 10 anni di servizio
        int stipendio2 = progetto.calcolaStipendioFunzionario("COD003");
        Assertions.assertEquals(3200, stipendio2);
    }
    @Test
    public void testCalcolaStipendioTecnico() throws DipendenteGiaEsistenteException, DipendenteNonEsisteException{
        progetto.aggiungiTecnico("Giueppe", "Verdi", "COD004", 2015, true, true, 40);

        // Verifica il calcolo dello stipendio per un tecnico interno e informatico
        int stipendio1 = progetto.calcolaStipendioTecnico("COD004");
        Assertions.assertEquals(1920, stipendio1);

        progetto.aggiungiTecnico("Marta", "Rossi", "COD005", 2010, true, false, 40);

        // Verifica il calcolo dello stipendio per un tecnico interno non informatico
        int stipendio2 = progetto.calcolaStipendioTecnico("COD005");
        Assertions.assertEquals(2520, stipendio2);
    }
    @Test
    public void testCalcolaTotaleStipendi() throws DipendenteGiaEsistenteException, DipendenteNonEsisteException{
        progetto.aggiungiDirigente("Simone", "Arzuffi", "COD001", 2020, true, 40);
        progetto.aggiungiFunzionario("Mario", "Rossi", "COD002", 2010, true, 40);
        progetto.aggiungiTecnico("Giuseppe", "Verdi", "COD003", 2015, true, true, 40);
    
        // Verifica il calcolo del totale degli stipendi per tutti i dipendenti
        int totaleStipendi = progetto.calcolaTotaleStipendi();
        Assertions.assertEquals(9120, totaleStipendi);
    }
}