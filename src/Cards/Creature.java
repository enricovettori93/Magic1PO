package Magic.Cards;

/**
 * Represents a Creature (CREATURA)
 * @author Enrico
 */
public class Creature extends Card {
    
    /**
     * This class indicates if the Creature is tapped or not
     */
    private boolean tapped;
    private int attack;
    private int defence;
    private AttackDefenceHandler handlerAD;
    
    /**
     * Create a new Creature (CREATURA)
     * @param name Creature's name
     * @param description Creature's description
     * @param attack Creature's attack points
     * @param defence Creature's defence points
     */
    public Creature(String name, String description, int attack, int defence){
        this.name=name;
        this.description=description;
        this.type="Creature";
        this.attack=attack;
        this.defence=defence;
        tapped=false;
        handlerAD = new AttackDefenceHandler(this.attack, this.defence);
    }
    
    public boolean getTapped(){
        return tapped;
    }
    
    public void setTapped(boolean state){
        tapped=state;
    }
    
    public void setAttack(int attack){
        this.attack = attack;
    }
    
    public int getAttack(){
        return handlerAD.getAttack();
    }
    
    public void setDefence(int defence){
        this.defence = defence;
    }
    
    public int getDefence(){
        return handlerAD.getDefence();
    }
    
    /*
    Method's for modify & reset the creature's handler
    */
    public void resetHandler(){
        handlerAD.resetHandler(this.attack, this.defence);
    }
    
    public void modifyDefence(int quantity){
        handlerAD.modifyDefence(quantity);
    }
    
    public void modifyAttack(int quantity){
        handlerAD.modifyAttack(quantity);
    }
    
    public void modifyAttackDefence(int quantityAtk, int quantityDef){
        handlerAD.modifyAttackDefence(quantityAtk,quantityDef);
    }
    
    @Override
    public void execute(){
        System.out.println("Eseguo l'effetto della creatura");
    }
    
    @Override
    public void removeCard(){
        System.out.println("Rimuovo l'effetto della carta");
    }
}
