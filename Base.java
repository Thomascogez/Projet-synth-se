import java.util.ArrayList;

/**
 * Base
 */
public class Base {

    private ArrayList<Cristal> cristaux;

    public Base() {
        this.cristaux = new ArrayList <Cristal>();
    }
    
    /** 
     * Methode permettant d'ajouter un crystal dans la base
     * 
     * @param c la crystal a ajouter
     */
    public void ajouterCristal(Cristal c){
        this.cristaux.add(c);
    }

    public ArrayList<Cristal> getCristaux() {
        return cristaux;
    }

    @Override
    public String toString() {
        return "Cristaux dans la base "+cristaux;
    }

   

}