import java.io.*;
import java.util.*;
public class Plateau {
	private final int NBCASE = 61;

	private CaseHexa[] terrain;
	private Joueur[]   tabJoueur;

	public Plateau(String[] nomJoueur){
		this.tabJoueur = new Joueur[nomJoueur.length];
		for (int i = 0 ; i< nomJoueur.length ;i++ ) {
			this.tabJoueur[i] = new Joueur(nomJoueur[i]);
		}
		this.terrain = setTerrain(nomJoueur.length);
	}

	private CaseHexa[] setTerrain(int nbJoueur){
		CaseHexa[] voisinsHexa;
		CaseHexa[] retour = new CaseHexa[NBCASE];
		String[] voisins  = new String  [NBCASE];
		int cpt = 0;
		final File fichier =new File("Data/Plateau"+nbJoueur+".data");
		try {
			Scanner sc = new Scanner (new FileReader( fichier) );

			while ( sc.hasNext() )
			{
				String[] infocase = sc.nextLine().split("/");
				retour[cpt] = new CaseHexa(infocase[0]);
				voisins[cpt] = infocase[1];
				cpt ++;
			}
		}
		catch (Exception e) {
			System.out.println("Impossible de cr\u00e9er le plateau");
		}
		for (int i = 0;i< NBCASE;i++ ) {
			voisinsHexa = new CaseHexa[6];
			String[] splitVoisins = voisins[i].split("-");
			for (int j = 0;j< voisinsHexa.length;j++) {
				if (!splitVoisins[j].equals("R")) {
					voisinsHexa[j] = retour[Integer.parseInt(splitVoisins[j])];
				}
			}
			retour[i].setVoisins(voisinsHexa);
		}
		return retour;
	}

	public String afficherPlateau(){
		String retour = "";
		int i = 0;
		final File fichier =new File("Data/Plateau.data");
		try {
			Scanner sc = new Scanner (fichier );

			while ( sc.hasNext() )
			{
				String s =  sc.next();
				if (s.equals("$")) {retour += " "+this.terrain[i++].getid()+" ";}
				else             {retour += s;}
			}
			retour = retour.replaceAll(	"3", "\n");
			retour = retour.replaceAll(	"1", " ");
			retour = retour.replaceAll(	"4", "    ");
		} catch (Exception e) {
		}
		return retour;
	}
}
