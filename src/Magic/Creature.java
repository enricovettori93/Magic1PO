package Magic;

/**
 * Rappresents a Creature (CREATURA)
 * @author Enrico
 */
public class Creature extends Card {
    
    /**
     * Indicates if the Creature is tapped or not
     */
    private boolean tapped;
    private int attack;
    private int defence;
    
    /**
     * Create a new Creature (CREATURA)
     * @param name The Creature name
     * @param description The Creature description
     * @param attack Creature's attack points
     * @param defence Creature's defence points
     */
    public Creature(String name, String description, int attack, int defence){
        this.name=name;
        this.description=description;
        this.type="Creature";
        this.attack=attack;
        this.defence=defence;
        tapped=true;
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
        return attack;
    }
    
    public void setDefence(int defence){
        this.defence = defence;
    }
    
    public int getDefence(){
        return defence;
    }
    
    public void modifyDefence(int quantity){
        this.defence = this.defence - quantity;
    }
    
    public void modifyAttack(int quantity){
        this.attack = this.attack - quantity;
    }
    
    public void modifyAttackDefence(int quantity){
        this.defence = this.defence - quantity;
        this.attack = this.attack - quantity;
    }
    
    @Override
    public void execute(){
        System.out.println("Eseguo l'effetto della creatura");
    }
}
