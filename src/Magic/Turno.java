package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Enrico
 */
public class Turno {
    Player g;
    InputStreamReader reader;
    BufferedReader myInput;
    public Turno(Player g){
        this.g=g;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }
    public void drawPhase(){
        System.out.println("\nInizio del turno di " + g.getNome() + ". Draw Phase.");
        if (g.carteMazzo()==0){
            g.setInGioco(false);
            endPhase();
        }
        g.estraiCarta();
        while(g.mano.size()>7){
            System.out.println(g.getNome() + " hai troppe carte in mano, quali vuoi scartare (indicare con un intero compreso l'indice della carta da rimuovere)?");
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
        System.out.println("Passaggio alla Untap Phase.");
        untapPhase();
    }
    public void untapPhase(){
        System.out.println("Passaggio alla Combat Phase.");
        combatPhase();
    }
    public void combatPhase(){
        System.out.println("In questa fase di gioco la combat non verrà gestita. Passaggio alla Main Phase e ciao ciao.");
        mainPhase();
    }
    public void mainPhase(){
        if(g.mano.isEmpty()){
            System.out.println(g.getNome() + " non hai carte da giocare. Fine turno.");
        }
        else{
            System.out.println(g.getNome() + " quale carte vuoi giocare (indicare con un indice intero la carta)?");
            g.stampaMano();
            int input=0;
            do{
                try {
                    System.out.print("\n-> ");
                    input=Integer.parseInt(myInput.readLine());
                    if((input<1)||(input>g.mano.size()+1)){
                        System.out.println("Indice errato");
                    }
                    else{
                        System.out.println(g.getNome() + " stai giocando la carta: " + input);
                        g.mano.remove(input-1);
                    }
                } catch (IOException ex) {
                    System.out.println ("Si è verificato un errore: " + ex);
                }
            }while((input>g.mano.size()+1)||(input<1));
        }
        System.out.println("Passaggio alla End Phase. Tocca al giocatore successivo.");
        endPhase();
    }
    public void endPhase(){}
}
