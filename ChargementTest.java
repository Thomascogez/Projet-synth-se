
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ChargementTest
 */
public class ChargementTest {
    private Properties prop;
    private int numTest;
    public ChargementTest(int numTest) {
        this.numTest = numTest;
        try (InputStream input = new FileInputStream(
                "liste_tests/test_"+this.numTest+".config")) {

            prop = new Properties();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}