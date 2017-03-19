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
    @params: attack -> increase/decrease momentarily monster's attack
    */
    public void modifyAttack(int attack){
        this.attack = this.attack + attack;
    }
    
    /*
    @params: defence -> increase/decrease momentarily monster's defence
    */
    public void modifyDefence(int defence){
        this.defence = this.defence + defence;
    }
    
    /*
    @params: attack -> increase/decrease momentarily monster's attack
    @params: defence -> increase/decrease momentarily monster's defence
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
    
    /*
    Reset the handler's monster to original value atk/def of the monster
    */
    public void resetHandler(int attack, int defence){
        this.attack = attack;
        this.defence = defence;
    }
}
