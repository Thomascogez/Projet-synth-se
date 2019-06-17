

import java.awt.Robot;

/**
 * Joueur
 */
public class Joueur {
    private static int PLAYER_ID = 0;
    private int id;
    private String nom;
    private Base baseJoueur;
    private int points;
    private Robot[] robots;

    public Joueur(String nom) {
        
        this.id = ++PLAYER_ID;
        this.nom = nom;
        this.baseJoueur = new Base();
        this.points = 0;
        this.robots = new Robot[2];

        //TODO : type de robot ?????
        this.initRobot();
    }

    private void initRobot(){
        robots[0] = new Robot();
        robots[1] = new Robot();
    }

    public void ajouterCristal(Cristal c){
        this.baseJoueur.ajouterCristal(c);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getPoint() {
        return points;
    }

    public void setPoint(int point){
        this.points += point;
    }


}