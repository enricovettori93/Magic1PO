package Magic.Cards;

/**
 * Represents a card
 * @author Enrico
 */
public abstract class Card implements InterfaceCard {
    /** Card's name */
    String name;
    /** Card's description */
    String description;
    
    /**Card's type */
    String type;
    
    /**
     * Base constructor
     */
    public Card(){}
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    
    /**
     * Set card's name
     * @param name Card's name
     */
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * Gets card's name
     * @return Card's name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Set card's description
     * @param description Card's description
     */
    public void setDescription(String description){
        this.description=description;
    }
    
    /**
     * Gets card's description
     * @return Card's description
     */
    public String getDescription(){
        return description;
    }
    /**
     * Gets card's type
     * @return Card's type
     */
    public String getType(){
        return type;
    }
    // </editor-fold>
    
    /**
     * The <i>specific</i> effect of the card. 
     * Each card that extends this class must provide its own implementation.
     */
}
