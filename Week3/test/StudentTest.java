import org.hofman.collection.LinkedList;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Maikel
 * Date: 16-2-13
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 */
public class StudentTest {
    LinkedList<Vak> vakken;

    @Before
    public void setUp() throws Exception {
        vakken = new LinkedList<Vak>();
        Vak vak1 = new Vak();
        vak1.setCijfer(7);
        vak1.setJaar(1);
        vak1.setModuleCode("TIRIETS");
        vakken.add(vak1);
        Vak vak2 = new Vak();
        vak1.setCijfer(9);
        vak1.setJaar(1);
        vak1.setModuleCode("TIRDAT1");
        vakken.add(vak2);
    }

    @Test
    public void testGemiddelde() throws Exception {
        Student student = new Student();

        for (int i =0; i < vakken.size(); i++)
        {
            student.addVak(vakken.get(i));
        }

        assertEquals(8.0, student.gemiddelde(), 0.00001);
    }
}
