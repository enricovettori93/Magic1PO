package Magic;

/**
 * Rappresents a card
 * @author Enrico
 */
public abstract class Card {
    /** The card name */
    String name;
    /** The card description */
    String description;
    
    /**
     * Base constructor
     */
    public Card(){}
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    /**
     * Set the card name
     * @param name The card name
     */
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * Gets the card name
     * @return The card name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set the card description
     * @param description The card description
     */
    public void setDescription(String description){
        this.description=description;
    }
    
    /**
     * Gets the card description
     * @return The card description
     */
    public String getDescription(){
        return description;
    }
    // </editor-fold>
    
    /**
     * The <i>specific</i> effect of the card. 
     * Each card that extends this class must provide its own implementation.
     */
    public abstract void execute();
}
