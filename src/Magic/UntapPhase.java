/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Magic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Enrico
 */
public class UntapPhase implements Phase {
    private CampoGioco cg;
    private Giocatore g;
    InputStreamReader reader;
    BufferedReader myInput;
    public UntapPhase(CampoGioco cg, Giocatore g){
        this.cg=cg;
        this.g=g;
        reader = new InputStreamReader(System.in);
        myInput = new BufferedReader(reader);
    }
    @Override
    public void initPhase() {
        System.out.println("Sono nella untap phase");
        int i;
        int input=0;
        //DEVO ACCEDERE ALLE LISTE DI MOSTRI IN CAMPO PER POTER SCEGLIERE QUALI TAPPARE/NON TAPPARE
        //SONO NEL GIOCATORE 1
        if(g.hashCode()==cg.getHashCodeG1()){
            if(cg.mostri_g1.size()>0){
                System.out.println(cg.getNomeG1()+" quali mostri vuoi tappare (indicare con un numero intero l'indice, -1 per non tappare nulla)?");
                for(i=0;i<cg.mostri_g1.size();i++){
                    //CONTROLLARE SE UN MOSTRO È GIA' TAPPATO O MENO
                    System.out.print(" "+cg.mostri_g1.get(i));
                }
                try {
                    System.out.print("\n-> ");
                    input=Integer.parseInt(myInput.readLine());
                    if(input!=-1){
                        if((input<1)||(input>cg.mostri_g1.size()+1)){
                            System.out.println("Indice errato");
                        }
                        else{
                            //TAPPA IL MOSTRO INDICATO NEL CAMPO DI GIOCO
                            cg.tapMonster(g,input);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println ("Si è verificato un errore: " + ex);
                }
            }
        }
        //SONO NEL GIOCATORE 2
        else{
            if(cg.mostri_g2.size()>0){
                System.out.println(cg.getNomeG2()+" quali mostri vuoi tappare (indicare con un numero intero l'indice, -1 per non tappare nulla)?");
                for(i=0;i<cg.mostri_g2.size();i++){
                    //CONTROLLARE SE UN MOSTRO È GIA' TAPPATO O MENO
                    System.out.print(" "+cg.mostri_g2.get(i));
                }
                try {
                    System.out.print("\n-> ");
                    input=Integer.parseInt(myInput.readLine());
                    if(input!=-1){
                        if((input<1)||(input>cg.mostri_g2.size()+1)){
                            System.out.println("Indice errato");
                        }
                        else{
                            //TAPPA IL MOSTRO INDICATO NEL CAMPO DI GIOCO
                            cg.tapMonster(g,input);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println ("Si è verificato un errore: " + ex);
                }
            }
        }
    }
    
}
