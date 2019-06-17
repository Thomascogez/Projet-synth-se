package config;

import java.io.File;
import java.util.Scanner;

/**
 * InitPlateau
 */
public class InitPlateau {
    private int nbJoueur;
    private File fichier;
    private Scanner sc;
    public InitPlateau(int nbJoueur) {
        this.nbJoueur = nbJoueur;
        
        try {
            fichier = new File("niveaux/n"+ nbJoueur +".data");
        } catch (Exception e) {
            throw e;
        }
    }

    public void lireNiveau(){
        try {
            sc = new Scanner(fichier);
            while (sc.hasNextLine()){
            
                
            }
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    
        
    }
}