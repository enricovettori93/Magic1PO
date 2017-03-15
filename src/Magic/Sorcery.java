package Magic;

/**
 * Rappresnets a Sorcery (STREGONERIA)
 * @author Enrico
 */
public class Sorcery extends Card{
    
    /**
     * Create a new Sorcery (STREGONERIA)
     * @param name The Sorcery name
     * @param description The Sorcery description
     */
    public Sorcery(String name, String description){
        this.name=name;
        this.description=description;
        this.type="Sourcery";
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
