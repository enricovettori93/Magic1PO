package Magic;

/**
 * Rappresents an Enchantment (INCANTAMENTO)
 * @author Enrico
 */
public class Enchantment extends Card {
    
    /**
     * Creates a new Enchantment (INCANTAMENTO)
     * @param name The Enchantment name
     * @param description The Enchantment description
     */
    public Enchantment(String name, String description){
        this.name=name;
        this.description=description;
    }
    
    @Override
    public void execute(){
        
    }
}
