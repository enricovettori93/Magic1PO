package Magic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Rappresnets a player
 *
 * @author Enrico
 */
public class Player {

    /**
     * The player name
     */
    private String name;

    /**
     * The initsal life points
     */
    private int lifePoints = 10;

    /**
     * The deck
     */
    private Stack<Integer> mazzo = new Stack<>();

    /**
     * The hand
     */
    protected List<Integer> mano = new ArrayList<>();

    /**
     * The round handler
     */
    private Round t;

    /**
     * Indicates if the player is currenlty in game or not
     */
    private Boolean ingioco = true;

    /**
     * The playground
     */
    private Playground playground;

    /**
     * The player magics
     */
    private List<Integer> magics = new ArrayList<>();

    /**
     * The player monsters
     */
    private List<Integer> monsters = new ArrayList<>();

    /**
     * Creates a new player
     *
     * @param name The player name
     * @param playground The playground
     */
    public Player(String name, Playground playground) {
        this.name = name;
        this.playground = playground;
        creaMazzo();
        creaMano();
    }

    /**
     * Creates a new player
     *
     * @param playground The playground
     */
    public Player(Playground playground) {
        this.playground = playground;
        creaMazzo();
        creaMano();
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean isInGame() {
        return ingioco;
    }

    public void setInGioco(Boolean boneggio) {
        ingioco = boneggio;
    }

    public List<Integer> getMagics() {
        return magics;
    }

    public void addMagic(Integer magic) {
        this.magics.add(magic);
    }

    public void addMagics(List<Integer> magics) {
        this.magics.addAll(magics);
    }

    public List<Integer> getMonsters() {
        return monsters;
    }

    public void addMonster(Integer monster) {
        this.monsters.add(monster);
    }

    public void addMonster(List<Integer> monsters) {
        this.monsters.addAll(monsters);
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Deck handlers">
    private void creaMazzo() {
        //DA IMPLEMENTARE IL FATTO CHE L'UTENTE DEBBA CREARSI IL MAZZO DI CARTE
        Random rand = new Random();
        int randomInt;
        for (int i = 0; i < 20; i++) {
            randomInt = rand.nextInt(20 - 1 + 1) + 1;
            mazzo.push(randomInt);
        }
    }

    public void stampaMazzo() {
        for (int i = 0; i < mazzo.size(); i++) {
            System.out.print(mazzo.get(i) + " ");
        }
    }

    public void estraiCarta() {
        if (mazzo.isEmpty()) {
            ingioco = false;
        } else {
            mano.add(mazzo.pop());
        }
    }

    /**
     * Gets the number of cards the player has in his deck
     * @return The number of card left in the deck
     */
    public int carteMazzo() {
        return mazzo.size();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Hand handlers">
        private void creaMano() {
        for (int i = 0; i < 5; i++) {
            mano.add(mazzo.pop());
        }
    }

    public void stampaMano() {
        for (int i = 0; i < mano.size(); i++) {
            System.out.print(mano.get(i) + " ");
        }
    }

    public void giocaCarta(int indice) {
        //SI DEVE CONTROLLARE SE è MOSTRO O MAGIA CON IF THEN ELSE, ORA ADDO ALLA LISTA MOSTRI DI DEFAULT
        playground.addMostro(mano.get(indice - 1), this);
        mano.remove(indice - 1);
        //CODICE DI DEBUG
        playground.stampaMagie(playground.player1);
        playground.stampaMagie(playground.player2);

        playground.stampaMostri(playground.player1);
        playground.stampaMostri(playground.player2);
    }
    // </editor-fold>
    

    /**
     * Initalize a new round
     */
    public void initTurno() {
        t = new Round(playground, this);
    }
}
