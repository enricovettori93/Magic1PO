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
public class Card {
    //ATTRIBUTI
    String nome;
    String descrizione;
    public Card(){}
    //GETTER E SETTER
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
    public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
    }
    public String getDescrizione(){
        return descrizione;
    }
    //METODO DI EFFETTO
    public void eseguiEffetto(){}
}
