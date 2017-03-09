/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 *
 * @author Enrico
 */
public class Giocatore {
    //Variabili dentro la classe giocatore
    private String nome;
    private int lifePoints;
    List<Integer> mostri;
    List<Integer> magie;
    Stack<Integer> mazzo;
    List<Integer> mano;
    TurnoNuovo t;
    Boolean ingioco;
    CampoGioco cg;
    //Costruttore
    public Giocatore(String nome, CampoGioco cg, List<Integer> mostri, List<Integer> magie){
        this.nome=nome;
        lifePoints=20;
        this.cg=cg;
        mazzo = new Stack<>();
        mano = new ArrayList<>();
        ingioco=true;
        this.mostri=mostri;
        this.magie=magie;
        creaMazzo();
        creaMano();
    }
    //Metodi getter e setter
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public int getLifePoints(){
        return lifePoints;
    }
    public void setLifePoints(int lifePoints){
        this.lifePoints=lifePoints;
    }   
    public boolean getInGioco(){
        return ingioco;
    }
    public void setInGioco(Boolean boneggio){
        ingioco=boneggio;
    }
    //Metodi per gestire il mazzo
    public void creaMazzo(){
        Random rand = new Random();
        int randomInt;
        for (int i = 0; i < 20; i++){
            randomInt = rand.nextInt(20 - 1 + 1) + 1;
            mazzo.push(randomInt);
        }
    }
    public void stampaMazzo(){
        for (int i = 0; i < mazzo.size(); i++){
            System.out.print(mazzo.get(i) + " ");
        }
    }
    public void estraiCarta(){
        if(mazzo.isEmpty()){
            ingioco=false;
        }
        else{
            mano.add(mazzo.pop());
        }
    }
    public int carteMazzo(){
        return mazzo.size();
    }
    //Metodi per gestire la mano
    public void creaMano(){
        for(int i = 0; i < 5; i++){
            mano.add(mazzo.pop());
        }
    }
    public void stampaMano(){
        for(int i = 0; i < mano.size(); i++){
            System.out.print(mano.get(i) + " ");
        }
    }
    public void giocaCarta(int indice){
        //SI DEVE CONTROLLARE SE è MOSTRO O MAGIA
        this.mostri.add(indice);
        //CODICE DI DEBUG
        cg.stampaMagie();
        cg.stampaMostri();
    }
    //Metodo per iniziare ogni turno
    public void initTurno(){
        t = new TurnoNuovo(cg,this);
    }
}
