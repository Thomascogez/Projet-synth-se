import java.io.*;
import java.util.*;
public class Plateau {
	private final int NBCASE = 61;

	private CaseHexa[] terrain;
	private Joueur[]   tabJoueur;

	public Plateau(String[] nomJoueur){
		this.tabJoueur = new Joueur[nomJoueur.length];
		for (int i = 0 ; i< nomJoueur.length ;i++ ) {
			this.tabJoueur = new Joueur(nomJoueur[i]);
		}
		this.terrain = setTerrain(nomJoueur.length);
	}

	private CaseHexa[] setTerrain(int nbJoueur){
		CaseHexa[] = voisinsHexa;
		CaseHexa[] retour = new CaseHexa[NBCASE];
		String[] voisins  = new String  [NBCASE];
		int cpt = 0;
		final File fichier =new File("Data/Plateau"+nbJoueur+".data");
		try {
			final FileWriter writer = new FileWriter(fichier);
			try {
				Scanner sc = new Scanner (new FileReader( source) );

			while ( sc.hasNext() )
			{
				String[] infocase = sc.nextLine().split("/");
				retour[cpt] = new CaseHexa(info[0]);
				voisins[cpt] = infocase[1];
				cpt ++;
			}
			}
		} catch (Exception e) {
			System.out.println("Impossible de cr\u00e9er le plateau");
		}
		for (int i = 0;i< NBCASE;i++ ) {
			voisinsHexa = new CaseHexa[6];
			String[] splitVoisins = voisins.split("-");
			for (int i = 0;i< NBCASE;i++) {
				if (!splitVoisins[i].equals("N")) {
					voisinsHexa = retour[Integer.parseInt(splitVoisins[i])];
				}
			}
			retour[i].setVoisins(voisinsHexa);
		}

		public String afficherPlateau(){
			String retour = "";
			int i = 0;
			final File fichier =new File("Data/Plateau.data");
			try {
				final FileWriter writer = new FileWriter(fichier);
				try {
					Scanner sc = new Scanner (new FileReader( source) );

				while ( sc.hasNext() )
				{
					StringBuffer buffer = sc.nextLine();;
					buffer.setCharAt('$', terrain[i++].getid() );
					retour +=  buffer.toString()+"\n";
				}
				}
			} catch (Exception e) {
			}
			return retour;
		}
	}
}
