import iut.algo.*;
/*Nom du programme : Test
@author Quentin Bernardin
Date :*/
public class Test
{
	public static void main(String[] args) {
		for (int i =0;i<3 ; i++) {
			System.out.print("Ordre " + (i+1) + " :");
			String AH = Clavier.lireString();
			System.out.println(AH);
		}
	}
}
