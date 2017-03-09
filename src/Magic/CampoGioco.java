/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Enrico
 */
public class CampoGioco {
    //DICHIARAZIONE VARIABILI
    private String nome1;
    private String nome2;
    private Giocatore g1;
    private Giocatore g2;
    //IDEA A CASO
    protected List<Integer> mostri_g1;
    protected List<Integer> mostri_g2;
    protected List<Integer> magie_g1;
    protected List<Integer> magie_g2;
    protected Stack<Integer> effetti;
    //FINE IDEA A CASO
    //FINE VARIABILI
    public CampoGioco(){
        //Inizializzo il campo di gioco
        mostri_g1 = new ArrayList<>();
        mostri_g2 = new ArrayList<>();
        magie_g1 = new ArrayList<>();
        magie_g2 = new ArrayList<>();
        effetti = new Stack();
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
        g1 = new Giocatore(nome1,this,mostri_g1,magie_g1);
        System.out.println("Giocatore 2, inserisci il tuo nome: ");
        do{
            try {
                nome2 = myInput.readLine();
            } catch (IOException e) {
                System.out.println ("Si è verificato un errore: " + e);
            }
        }while(nome2.equals(""));
        g2 = new Giocatore(nome2,this,mostri_g1,magie_g2);
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
    public void stampaMagie(){
        int i;
        System.out.println("Magie giocatore " + g1.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.println(""+magie_g1.get(i));
        }
        System.out.println("Magie giocatore " + g2.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.println(""+magie_g2.get(i));
        }
    }
    public void stampaMostri(){
        int i;
        System.out.println("Mostri giocatore " + g1.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.println(""+mostri_g1.get(i));
        }
        System.out.println("Mostri giocatore " + g2.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.println(""+mostri_g2.get(i));
        }
    }
}
