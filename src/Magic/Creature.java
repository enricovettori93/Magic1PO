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
//CREATURA
public class Creature extends Card {
    private boolean untapped;
    public Creature(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
        untapped=true;
    }
    @Override
    public void eseguiEffetto(){
        System.out.println("Eseguo l'effetto della creatura");
    }
}
