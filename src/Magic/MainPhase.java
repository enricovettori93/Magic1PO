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
    public MainPhase(CampoGioco cg){
        this.cg=cg;
    }
    @Override
    public void initPhase() {
        System.out.println("Sono nella main phase");
    }
    
}
