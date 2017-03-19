package Magic.Rounds;

import Magic.Game.Player;
import Magic.Game.Playground;

/**
 * Represents combat phase
 * @author Enrico
 */
public class CombatPhase implements Phase {
    /**
     * Playground
     */
    private Playground playground;
    
    /**
     * Player
     */
    private Player g;

    /**
     * Inits combat phase
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
