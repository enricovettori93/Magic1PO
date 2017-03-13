package Magic;

/**
 * Rappresents a Creature (CREATURA)
 * @author Enrico
 */
public class Creature extends Card {
    
    /**
     * Indicates if the Creature is untapped or not
     */
    private boolean untapped;
    
    /**
     * Create a new Creature (CREATURA)
     * @param name The Creature name
     * @param description The Creature description
     */
    public Creature(String name, String description){
        this.name=name;
        this.description=description;
        this.type="Creature";
        untapped=true;
    }
    @Override
    public void execute(){
        System.out.println("Eseguo l'effetto della creatura");
    }
}
