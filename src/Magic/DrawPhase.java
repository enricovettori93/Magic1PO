/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Enrico
 */
public class DrawPhase implements Phase {
    private CampoGioco cg;
    private Giocatore g;
    InputStreamReader reader;
    BufferedReader myInput;
    public DrawPhase(CampoGioco cg, Giocatore g){
        this.cg=cg;
        this.g=g;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }
    @Override
    public void initPhase() {
        System.out.println("\nInizio del turno di " + g.getNome() + ". Draw Phase.");
        checkEmptyDeck();
        if(g.getInGioco()){
            g.estraiCarta();
            checkHand();
        }
    }
    private void checkEmptyDeck(){
        if (g.carteMazzo()==0){
            g.setInGioco(false);
        }
    }
    private void checkHand(){
        while(g.mano.size()>7){
            System.out.println(g.getNome() + " hai troppe carte in mano, quali vuoi scartare (indicare con un intero l'indice della carta da rimuovere)?");
            g.stampaMano();
            System.out.println("");
            int input=0;
            do{
                try {
                    System.out.print("\n-> ");
                    input=Integer.parseInt(myInput.readLine());
                    if((input<1)||(input>g.mano.size()+1)){
                        System.out.println("Indice errato");
                    }
                    else{
                        g.mano.remove(input-1);
                    }
                } catch (IOException ex) {
                    System.out.println ("Si è verificato un errore: " + ex);
                }
            }while((input>g.mano.size()+1)||(input<1));
        }
    }
}
