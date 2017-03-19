package Magic.Cards;

/**
 * Represents an Instant (ISTANTANEO)
 * @author Enrico
 */
public class Instant extends Card{
    
    /**
     * Creates a new Instant (ISTANTANEO)
     * @param name Instant's name
     * @param description Instant's description
     */
    public Instant(String name, String description){
        this.name=name;
        this.description=description;
        this.type="Instant";
    }
    @Override
    public void execute(){
        System.out.println("Im an Instant!");
    }
    
    @Override
    public void removeCard(){
        System.out.println("Rimuovo l'effetto della carta");
    }
}
