package Magic;

/**
 * Rappresnets the end phase
 *
 * @author Enrico
 */
public class EndPhase implements Phase {

    /**
     * The playground
     */
    private Playground playground;

    /**
     * The player
     */
    private Player player;

    /**
     * Initalize the end phase
     *
     * @param playground The playground
     * @param player The player
     */
    public EndPhase(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
    }

    @Override
    public void initPhase() {
        System.out.println("Sono nella End phase");
    }

}
