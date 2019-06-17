/**
 * Joueur
 */
public class Joueur
{
    private String nom;
    private String couleur;
    private Base baseJoueur;
    private int points;
    private Robot[] robots;

    public Joueur(String nom, String couleur)
    {
        this.nom = nom;
        this.couleur = couleur;
        this.baseJoueur = new Base();
        this.points = 0;
        this.robots = new Robot[2];

        //TODO : type de robot ?????
        this.initRobot();
    }

    private void initRobot(){
        robots[0] = new Robot(couleur);
        robots[1] = new Robot(couleur);
    }

    public void ajouterCristal(Cristal c){
        this.baseJoueur.ajouterCristal(c);
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