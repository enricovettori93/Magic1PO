/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

/**
 *
 * @author Enrico
 */
public class MainPhase implements Phase {
    private CampoGioco cg;
    private Giocatore g;
    public MainPhase(CampoGioco cg, Giocatore g){
        this.cg=cg;
        this.g=g;
    }
    @Override
    public void initPhase() {
        System.out.println("Sono nella main phase");
    }
    
}
