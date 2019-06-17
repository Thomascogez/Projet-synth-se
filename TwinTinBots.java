import java.util.ArrayList;

/**
 * TwinTinBots
 */
public class TwinTinBots {

    private ArrayList<Joueur> ljoueur;

    public TwinTinBots() {
        this.ljoueur = new ArrayList<Joueur>();
    }

    public void chargerPlateau() {
    }

    // ------------------
    // ---- Joueur ------
    // ------------------

    public void ajouterJoueur(Joueur j) {
        this.ljoueur.add(j);
    }

    public Joueur getJoueurParId(int index) {
        if (index >= 0 && index < this.ljoueur.size()) {
            return this.ljoueur.get(index);
        }
        return null;
    }
    // ------------------
    // ---- Jeux --------
    // ------------------

    private int changerJoueur(int idx) {
        if (idx + 1 > ljoueur.size() - 1) {
            return 0;
        }
        return idx + 1;
    }

    public void demarrerJeux() {
        int idxJoueurActuel = 0;
        Joueur joueurActuel = this.getJoueurParId(idxJoueurActuel);

        while(true){  //condition de victoire
            while(true){ //pendant que le joueur joue
                //controlleur.affichermenu
                //controlleur.lireAction
                    //si modif programme
                    //choix robot
                    //choix carte a modifier
                //controlleur.executer
                //(les robot execute leurs actions)
            }
            //changer joueur
        }

    }

}