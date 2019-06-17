package metier;

import java.util.ArrayList;

/**
 * TwinTinBots
 */
public class TwinTinBots {

    private ArrayList<Joueur> ljoueur;

    public TwinTinBots() {
        this.ljoueur = new ArrayList<Joueur>();
    }

    
    public void chargerPlateau(){
    }

    //------------------
    //---- Joueur ------ 
    //------------------

    public void ajouterJoueur(Joueur j){
        this.ljoueur.add(j);
    }

    public Joueur getJoueur(int index){
        if(index >= 0 && index < this.ljoueur.size()){
            return this.ljoueur.get(index);
        }
        return null;
    }




}