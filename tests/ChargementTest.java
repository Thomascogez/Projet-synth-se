

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ChargementTest
 */
public class ChargementTest {
    private Properties prop;

    public ChargementTest() {
        try (InputStream input = new FileInputStream("C:/Users/wedzy/Desktop/Projet-synth-se/tests/liste_tests/test_1.config")) {

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