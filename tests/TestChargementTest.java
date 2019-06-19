
/**
 * TestChargementTest
 */
public class TestChargementTest {

    public static void main(String[] args) {
        ChargementTest ct = new ChargementTest();
        String[] tabSequence = ct.getProperty("SEQUENCE_TEST").trim().split("#");
        int nbSeqTotal = 0;
        for (String s : tabSequence) {
            System.out.println("Joueur N°"+s.split("/")[0].split(":")[0]);
            System.out.println("Robot N°"+s.split("/")[0].split(":")[1]);
            System.out.println("Séquence :"+s.split("/")[1]+"\n\n\n");
        }

        

    }
}