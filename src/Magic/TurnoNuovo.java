/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enrico
 */
public class TurnoNuovo {
    private CampoGioco cg;
    private Giocatore g;
    List<Phase> fasi;
    /*
    Decodifica fasi:
    0 - Draw
    1 - Untap
    2 - Combat
    3 - Main
    4 - End
    */
    public TurnoNuovo(CampoGioco cg, Giocatore g){
        this.cg=cg;
        this.g=g;
        fasi = new ArrayList<>();
        creaTurno();
    }
    public void creaTurno(){
        int i;
        /*
        Si va a controllare nel campo da gioco gli eventuali effetti attivi che modificano
        le fasi e si crea il vettore di fasi
        */
        fasi.add(new DrawPhase(cg));
        fasi.add(new UntapPhase(cg));
        fasi.add(new CombatPhase(cg));
        fasi.add(new MainPhase(cg));
        fasi.add(new EndPhase(cg));
        for(i=0;i<fasi.size();i++){
            fasi.get(i).initPhase();
        }
    }
}
