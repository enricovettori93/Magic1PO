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
    Stack<Integer> mazzo = new Stack<>();
    List<Integer> mano = new ArrayList<>();
    Turno t;
    Boolean ingioco;
    //Costruttori
    public Giocatore(){
        this.nome="";
        lifePoints=20;
        creaMazzo();
        creaMano();
        ingioco=true;
        t = new Turno(this);
    }
    public Giocatore(String nome){
        this.nome=nome;
        lifePoints=20;
        creaMazzo();
        creaMano();
        ingioco=true;
        t = new Turno(this);
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
    //Metodo per iniziare ogni turno
    public void initTurno(){
        t.drawPhase();
    }
}
