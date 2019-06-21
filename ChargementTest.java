
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * ChargementTest.
 */
public class ChargementTest {
    
    /** The prop. */
    private Properties prop;
    
    /** The num test. */
    private int numTest;
    
    /**
     * Instantiates a new chargement test.
     *
     * @param numTest the num test
     */
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

    /**
     * Gets the property.
     *
     * @param key the key
     * @return the property
     */
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}