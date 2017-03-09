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
//ISTANTANEO
public class Instant extends Card{
    public Instant(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
    }
    @Override
    public void eseguiEffetto(){
        System.out.println("");
    }
}
