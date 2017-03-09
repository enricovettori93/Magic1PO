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
public class MainPhase implements Phase {
    private CampoGioco cg;
    private Giocatore g;
    InputStreamReader reader;
    BufferedReader myInput;
    public MainPhase(CampoGioco cg, Giocatore g){
        this.cg=cg;
        this.g=g;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }
    @Override
    public void initPhase() {
        System.out.println(g.getNome() + " quale carta desideri giocare (indicare con un intero l'indice della carta)?");
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
                    g.giocaCarta(input);
                }
            } catch (IOException ex) {
                System.out.println ("Si è verificato un errore: " + ex);
            }
        }while((input>g.mano.size()+1)||(input<1));
    }
}
