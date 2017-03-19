package Magic.Game;

import Magic.Rounds.Round;
import Magic.Cards.Instant;
import Magic.Cards.Card;
import Magic.Cards.Creature;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represnets a player
 *
 * @author Enrico
 */
public class Player {

    /**
     * Player's name
     */
    private String name;

    /**
     * Starting life points
     */
    private int lifePoints = 10;

    /**
     * Deck
     */
    private List<Card> mazzo = new ArrayList<>();

    /**
     * Hand
     */
    protected List<Card> mano = new ArrayList<>();

    /**
     * Round's handler
     */
    private Round round;

    /**
     * It indicates if the player is currenlty in game or not
     */
    private Boolean ingioco = true;

    /**
     * Playground
     */
    private Playground playground;

    /**
     * Player's magics
     */
    private List<Card> magics = new ArrayList<>();

    /**
     * Player's monsters
     */
    private List<Creature> monsters = new ArrayList<>();
    
    /**
     * Input stream
     */
    private InputStreamReader reader;
    
    /**
     * Buffer's reader
     */
    private BufferedReader myInput;
    
    /**
     * Variable that checks if program launches an exception
     */
    private boolean throwedexc = false;
    
    /**
     * Creates a new player
     *
     * @param playground The playground
     */
    public Player(Playground playground) {
        this.playground = playground;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
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

    public void setInGioco(Boolean ingioco) {
        this.ingioco = ingioco;
    }

    public List<Card> getMagics() {
        return magics;
    }

    public void addMagic(Card magic) {
        this.magics.add(magic);
    }

    public void addMagics(List<Card> magics) {
        this.magics.addAll(magics);
    }

    /*List of creatures and not of cards!*/
    public List<Creature> getMonsters() {
        return monsters;
        
    }

    public void addMonster(Creature monster) {
        this.monsters.add(monster);
    }

    public void addMonster(List<Creature> monsters) {
        this.monsters.addAll(monsters);
    }
    
    public List<Card> getMano(){
        return mano;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Deck handlers">
    protected void creaMazzo() {
        int i=0;
        int carta=0;
        System.out.println(this.getNome() + " seleziona la carta " + (i+1) + " da inserire nel mazzo (presente solo omeophaty)");
        System.out.println("1 - Omeophaty");
        do{
            do{
                throwedexc=false;
                try {
                    try{
                        System.out.print((i+1)+" di 20 : ");
                        carta = Integer.parseInt(myInput.readLine());
                    }
                    catch(NumberFormatException exc){
                        System.out.println("Input errato.");
                        throwedexc=true;
                    }
                } catch (IOException ex) {
                    System.out.println("Errore " + ex);
                }
            }while(carta != 1 || throwedexc == true);
            i++;
            mazzo.add(new Instant("Omeophaty","Omeophaty does nothing"));
        }while(i<20);
        Collections.shuffle(mazzo);
    }

    public void stampaMazzo() {
        for (int i = 0; i < mazzo.size(); i++) {
            System.out.print(mazzo.get(i).getName() + " ");
        }
    }

    public void estraiCarta() {
        if (mazzo.isEmpty()) {
            ingioco = false;
        } else {
            mano.add(mazzo.get(mazzo.size()-1));
            mazzo.remove(mazzo.size()-1);
        }
    }

    /**
     * The method carteMazzo() gets the number of cards that the player has in his deck
     * @return The number of cards left in the deck
     */
    public int carteMazzo() {
        return mazzo.size();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Hand handlers">
    protected void creaMano() {
        for (int i = 0; i < 5; i++) {
            mano.add(mazzo.get(mazzo.size()-1));
            mazzo.remove(mazzo.size()-1);
        }
    }

    public void stampaMano() {
        for (int i = 0; i < mano.size(); i++) {
            System.out.print((i+1) + "-" + mano.get(i).getName() + " " + mano.get(i).getType() + " ");
        }
    }
    
    /**
     *This method checks if the player can and would use istant card, otherwise the method does nothing
     * @return true if the player use an istant card, otherwise it return false. 
     */
    public boolean checkIstantToPlay(){
        boolean iveIstant = false;
        int i;
        for(i=0;i<mano.size();i++){
            if("Instant".equals(mano.get(i).getType())){
                iveIstant=true;
            }
        }
        if(!mano.isEmpty() && iveIstant == true){
            System.out.println(getNome() + " vuoi giocare un istantaneo (-1 per uscire)?");
            Card app;
            stampaMano();
            int carta=0;
            do{
                do{
                    throwedexc=false;
                    try {
                        System.out.print("-> ");
                        try{
                            carta = Integer.parseInt(myInput.readLine());
                        }
                        catch(NumberFormatException exc){
                            System.out.println("Input errato.");
                            throwedexc=true;
                        }
                        if(carta != -1 && throwedexc == false)
                            carta --;
                    } catch (IOException ex) {
                        System.out.println("Errore " + ex);
                    }
                    if(carta==-1){
                        return false;
                    }
                }while(carta<0 || carta>mano.size() || throwedexc == true);
                app=mano.get(carta);
                if("Instant".equals(app.getType())){
                    playground.addStack(app,this);
                    //magics.add(app);
                    mano.remove(carta);
                    return true;
                }
                else{
                    System.out.println("Tipologia di carta non valida");
                }
            }while((!"Instant".equals(app.getType())));
            return false;
        }
        else{
            return false;
        }
    }
    
    public void giocaCarta(int indice) {
        if("Instant".equals(mano.get(indice-1).getType()) || "Enchantment".equals(mano.get(indice-1).getType())  || "Sourcery".equals(mano.get(indice-1).getType())){
            //if(!"Istant".equals(mano.get(indice-1).getType()))
            addMagic(mano.get(indice-1));
            playground.addStack(mano.get(indice-1),this);
            mano.remove(indice-1);
            playground.checkIstantOtherPlayer(this);
        }
        else{
            addMonster((Creature)mano.get(indice-1));
            mano.remove(indice-1);
            playground.checkIstantOtherPlayer(this);
        }
    }
    // </editor-fold>
    
    public void tapMonster(int index){
        monsters.get(index).setTapped(true);
    }
    /**
     * Initialize a new round
     */
    public void initRound() {
        round = new Round(playground, this);
    }
    /**
     * I clean playground from Sorcery that have been played and are not enchantment
     */
    public void cleanMagicsOnGround(){
        for(int i=0; i<magics.size();i++)
            if(magics.get(i).getType().equals("Sorcery"))
                magics.remove(i);
    }
    public void printPlayerPlayground(){
        System.out.print("Sorceries : ");
        for(int i=0; i<getMagics().size();i++)
            if(getMagics().get(i).getType().equals("Sorcery"))
                System.out.print(getMagics().get(i).getName() + " ");
        System.out.println("\n");
        System.out.print("Enchantments : ");
        for(int i=0; i<getMagics().size();i++)
            if(getMagics().get(i).getType().equals("Enchantment"))
                System.out.print(getMagics().get(i).getName() + " ");
        System.out.println("\n");
        System.out.print("Instants : ");
        for(int i=0; i<getMagics().size();i++)
            if(getMagics().get(i).getType().equals("Instant"))
                System.out.print(getMagics().get(i).getName() + " ");
        System.out.println("\n");
        System.out.print("Creatures : ");
        for(int i=0; i<getMonsters().size();i++){
            if(getMonsters().get(i).getTapped()){
                System.out.print(getMonsters().get(i).getName() + " - T ");
            }
            else{
                System.out.print(getMonsters().get(i).getName() + " - U ");
            }
        }
        System.out.println("\n");
    }
    
    /*
    Reset all monster's handler
    */
    public void resetMonsterHandler(){
        for(int i=0;i<monsters.size();i++){
            monsters.get(i).resetHandler();
        }
    }
}
