package Magic.Cards;

/**
 * Represents a card
 * @author Enrico
 */
public abstract class Card implements InterfaceCard {
    /** The card name */
    String name;
    /** The card description */
    String description;
    
    /**The card type */
    String type;
    
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
    /**
     * Gets the card type
     * @return The card type
     */
    public String getType(){
        return type;
    }
    // </editor-fold>
    
    /**
     * The <i>specific</i> effect of the card. 
     * Each card that extends this class must provide its own implementation.
     */
    
    //public abstract void execute();
}