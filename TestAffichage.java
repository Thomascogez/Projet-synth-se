/**
 * TestAffichage
 */
public class TestAffichage {

    public static void main(String[] args) {
        String test ="$34$45     ";
        String[] splitted = test.split("\\$");
        for (String s : splitted) {
            System.out.println(s.substring(s.trim().lastIndexOf("$")+1));
        }
      
    }
}