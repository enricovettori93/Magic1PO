/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic.Cards;

/**
 *
 * @author Enrico
 */
public class AttackDefenceHandler {
    private int attack;
    private int defence;
    public AttackDefenceHandler(int attack, int defence){
        this.attack = attack;
        this.defence = defence;
    }
    
    /*
    @params: attack -> aumenta/diminuisce attacco momentaneamente del mostro
    */
    public void modifyAttack(int attack){
        this.attack = this.attack + attack;
    }
    
    /*
    @params: attack -> aumenta/diminuisce attacco momentaneamente del mostro
    @params: defence -> aumenta/diminuisce difesa momentaneamente del mostro
    */
    public void modifyDefence(int defence){
        this.defence = this.defence + defence;
    }
    
    /*
    @params: defence -> aumenta/diminuisce difesa momentaneamente del mostro
    */
    public void modifyAttackDefence(int attack, int defence){
        this.attack = this.attack + attack;
        this.defence = this.defence + defence;
    }
    
    public int getAttack(){
        return this.attack;
    }
    
    public int getDefence(){
        return this.defence;
    }
    
    public void resetHandler(int attack, int defence){
        this.attack = attack;
        this.defence = defence;
    }
}
