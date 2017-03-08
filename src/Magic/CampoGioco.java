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
public class CampoGioco {
    private String nome1;
    private String nome2;
    private Giocatore g1;
    private Giocatore g2;
    public CampoGioco(){
        //Inizializzo il campo di gioco
        inizializza();
        gioco();
    }
    public void gioco(){
        while(g1.getInGioco() && g2.getInGioco()){
            g1.initTurno();
            if(g1.getInGioco()){
                g2.initTurno();
            }
        }
        if(g1.getInGioco()){
            System.out.println("Bravo " + g1.getNome() + " hai vinto!");
        }
        else{
            System.out.println("Bravo " + g2.getNome() + " hai vinto!");
        }
    }
    public void inizializza(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader myInput = new BufferedReader(reader);
        //Creo i giocatori
        System.out.println("Giocatore 1, inserisci il tuo nome: ");
        do{
            try {
                nome1 = myInput.readLine();
            } catch (IOException e) {
                System.out.println ("Si è verificato un errore: " + e);
            }
        }while(nome1.equals(""));
        g1 = new Giocatore(nome1);
        System.out.println("Giocatore 2, inserisci il tuo nome: ");
        do{
            try {
                nome2 = myInput.readLine();
            } catch (IOException e) {
                System.out.println ("Si è verificato un errore: " + e);
            }
        }while(nome2.equals(""));
        g2 = new Giocatore(nome2);
        //Visualizzo i mazzi
        System.out.println("\nMazzo di " + g1.getNome());
        g1.stampaMazzo();
        System.out.println("\nMazzo di " + g2.getNome());
        g2.stampaMazzo();
        //Visualizzo le mani di entrambi i giocatori
        System.out.println("\nCarte iniziali di " + g1.getNome());
        g1.stampaMano();
        System.out.println("\nCarte iniziali di " + g2.getNome());
        g2.stampaMano();
    }
}
