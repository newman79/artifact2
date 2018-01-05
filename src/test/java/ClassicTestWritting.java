

import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import main.App;

/**
 * Classic test for simple App. It contains to test methods.
 * A TestSuite is created by getting via reflect API all methods whose name start with "test"
 */
public class ClassicTestWritting  extends TestCase
{
	App app;

	// Retourne un objet qui contient la suite d'objet TestCase
	// Chaque objet TestCase correspond à un test, i.e une méthode de test de ce TestCase (ce sont les méthodes test ...())
	// Cette méthode statique n'est pas utilisée par JUnit, mais peut être par maven
    public static Test suite() { return new TestSuite(ClassicTestWritting.class); }

     // Invoqué par lors de la construction de la suite de tests
    public ClassicTestWritting(String testName)
    {
        super(testName); // testName correspond au nom d'une méthode de test de ce TestCase
    }

    // Avant l'éxécution
    public void setUp()
    {
    	Logger.getGlobal().info("--- AppTest.setUp() ---");
    	app = new App();
    }

    // Apres l'exécution
    public void tearDown() {
    	Logger.getGlobal().info("--- AppTest.tearDown() ---");
    }

    // Methode de test 1
    public void test_App_1()
    {
    	Logger.getGlobal().info("************ TEST_APP_1 **************");
    	app.loadProperties();
        assertTrue( app.getProperties() != null );
        assertEquals( app.getProperties().get("fff"), "jjj" );
        assertNull( app.getProperties().get("uneProprieteQuiNexistePas") );
    }

    // Methode de test 2
    public void test_App_2()
    {
    	Logger.getGlobal().info("************ TEST_APP_2 **************");
        assertFalse("Le test sera incorrect".equals(null));
    }
}