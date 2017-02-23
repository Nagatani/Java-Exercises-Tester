import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
/**
 *
 * @author Nagatani
 */
public class JUnitSIOTestBase {

    protected StandardOutputSnatcher out = new StandardOutputSnatcher();
    protected StandardInputSnatcher in = new StandardInputSnatcher();

    @BeforeClass
    public static void setUpClass() {
    }
    @AfterClass
    public static void tearDownClass() {
    }
    @Before
    public void before() {
        System.setOut(out);
        System.setIn(in);
    }
    @After
    public void after() {
        System.setOut(null);
        System.setIn(null);
    }
}
