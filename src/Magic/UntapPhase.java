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
public class UntapPhase implements Phase {
    private CampoGioco cg;
    public UntapPhase(CampoGioco cg){
        this.cg=cg;
    }
    @Override
    public void initPhase() {
        System.out.println("Sono nella untap phase");
    }
    
}
