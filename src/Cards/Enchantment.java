package Magic.Cards;

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
