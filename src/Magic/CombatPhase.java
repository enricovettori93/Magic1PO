package Magic;

/**
 * Rappresents the combat phase
 * @author Enrico
 */
public class CombatPhase implements Phase {
    /**
     * Th eplayground
     */
    private Playground playground;
    
    /**
     * The player
     */
    private Player g;

    /**
     * Inits the combat phase
     * @param playground The playground
     * @param player The player
     */
    public CombatPhase(Playground playground, Player player) {
        this.playground = playground;
        this.g = player;
    }

    @Override
    public void initPhase() {
        System.out.println("Sono nella combat phase (non gestita in questo assignment)");
    }

}
