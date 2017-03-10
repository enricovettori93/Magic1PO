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
        g1 = new Giocatore(nome1,this);
        System.out.println("Giocatore 2, inserisci il tuo nome: ");
        do{
            try {
                nome2 = myInput.readLine();
            } catch (IOException e) {
                System.out.println ("Si è verificato un errore: " + e);
            }
        }while(nome2.equals(""));
        g2 = new Giocatore(nome2,this);
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
    //METODI DI DEBUG PER STAMPARE MOSTRI E MAGIE IN CAMPO
    public void stampaMagie(){
        int i;
        System.out.println("\nMagie giocatore " + g1.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.print(" "+magie_g1.get(i));
        }
        System.out.println("\nMagie giocatore " + g2.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.print(" "+magie_g2.get(i));
        }
        System.out.println("\n");
    }
    public void stampaMagieG1(){
        int i;
        System.out.println("\nMagie giocatore " + g1.getNome());
        for(i=0;i<magie_g1.size();i++){
            System.out.print(" "+magie_g1.get(i));
        }
        System.out.println("\n");
    }
    public void stampaMagieG2(){
        int i;
        System.out.println("\nMagie giocatore " + g2.getNome());
        for(i=0;i<magie_g2.size();i++){
            System.out.print(" "+magie_g2.get(i));
        }
        System.out.println("\n");
    }
    public void stampaMostri(){
        int i;
        System.out.println("\nMostri giocatore " + g1.getNome());
        for(i=0;i<mostri_g1.size();i++){
            System.out.print(" "+mostri_g1.get(i));
        }
        System.out.println("\nMostri giocatore " + g2.getNome());
        for(i=0;i<mostri_g2.size();i++){
            System.out.print(" "+mostri_g2.get(i));
        }
        System.out.println("\n");
    }
    public void stampaMostriG1(){
        int i;
        System.out.println("\nMostri giocatore " + g1.getNome());
        for(i=0;i<mostri_g1.size();i++){
            System.out.print(" "+mostri_g1.get(i));
        }
        System.out.println("\n");
    }
    public void stampaMostriG2(){
        int i;
        System.out.println("\nMostri giocatore " + g2.getNome());
        for(i=0;i<mostri_g2.size();i++){
            System.out.print(" "+mostri_g2.get(i));
        }
        System.out.println("\n");
    }
    //METODI PER AGGIUNGERE MOSTRI E MAGIE ALLE LISTE IN CAMPO IN BASE AL GIOCATORE CHE HA GIOCATO LA CARTA
    public void addMostro(Integer i,Giocatore g){
        if(g.hashCode()==g1.hashCode()){
            mostri_g1.add(i);
        }
        else{
            mostri_g2.add(i);
        }
    }
    public void addMagia(Integer i,Giocatore g){
        if(g.hashCode()==g1.hashCode()){
            magie_g1.add(i);
        }
        else{
            magie_g2.add(i);
        }
    }
    public int getHashCodeG1(){
        return g1.hashCode();
    }
    public int getHashCodeG2(){
        return g2.hashCode();
    }
    public String getNomeG1(){
        return g1.getNome();
    }
    public String getNomeG2(){
        return g2.getNome();
    }
}
