package Magic;

/**
 * Rappresents an Instant (ISTANTANEO)
 * @author Enrico
 */
public class Instant extends Card{
    
    /**
     * Creates a new Instant (ISTANTANEO)
     * @param name The Instant name
     * @param description The Instant description
     */
    public Instant(String name, String description){
        this.name=name;
        this.description=description;
        this.type="Istant";
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
