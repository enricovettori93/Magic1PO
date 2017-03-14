package Magic;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresents a Round
 *
 * @author Enrico
 */
public class Round {

    private Playground playground;
    private Player player;
    List<Phase> fasi;

    public Round(Playground playground, Player player) {
        this.playground = playground;
        this.player = player;
        fasi = new ArrayList<>();
        creaTurno();
    }

    private void creaTurno() {
        int i;
        /*
        Si va a controllare nel campo da gioco gli eventuali effetti attivi che modificano
        le fasi e si crea il vettore di fasi
         */
        
        fasi.add(new DrawPhase(playground, player));
        if(player.isInGame()){
            fasi.add(new UntapPhase(playground, player));
            fasi.add(new CombatPhase(playground, player));
            fasi.add(new MainPhase(playground, player));
            fasi.add(new EndPhase(playground, player));
            
            System.out.println("\n");
            playground.printPlayground(player);
            
            for (i = 0; i < fasi.size(); i++) {
                fasi.get(i).initPhase();
            }
        }
    }
}
