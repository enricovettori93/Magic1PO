package Magic.Cards;

/**
 * Represents an Enchantment (INCANTAMENTO)
 * @author Enrico
 */
public class Enchantment extends Card {
    
    /**
     * Creates a new Enchantment (INCANTAMENTO)
     * @param name Enchantment's name
     * @param description Enchantment's description
     */
    public Enchantment(String name, String description){
        this.name=name;
        this.description=description;
        this.type="Enchantment";
    }
    
    @Override
    public void execute(){
        System.out.println("Eseguo l'effetto della carta");
    }
    
    @Override
    public void removeCard(){
        System.out.println("Rimuovo l'effetto della carta");
    }
}
