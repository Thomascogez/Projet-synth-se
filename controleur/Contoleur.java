package controleur;

import iut.algo.Clavier;
import metier.TwinTinBots;
/**
 * Contoleur
 */
public class Contoleur {

    private TwinTinBots twinTinBots;


    public Contoleur() {
        //this.twinTinBots = new TwinTinBots();
    }

    public void start(){

    }

    public int lireAction(){
        return Clavier.lire_int();
    }


    public void action(int action){

    }

}