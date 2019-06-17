import iut.algo.*;

/**
 * IhmCui
 */
public class IhmCui {

    public void ecranDemarrage() {
        System.out.println(
                "  _   _   _   _     _   _   _     _   _   _   _  \r\n / \\ / \\ / \\ / \\   / \\ / \\ / \\   / \\ / \\ / \\ / \\ \r\n( T | w | i | n ) ( T | i | n ) ( B | o | t | s )\r\n \\_/ \\_/ \\_/ \\_/   \\_/ \\_/ \\_/   \\_/ \\_/ \\_/ \\_/ ");
    }

    public void menuAction() {
        Console.println("\tVoulez-vous modifier un programme avant execution ? : \n\n" + "\t\t"+ CouleurConsole.VERT.getFont() +" 1 - Oui\n" + "\t\t"+ CouleurConsole.ROUGE.getFont() +" 2 - Non");
        Console.normal();
    }

}