import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveCard() {
        new Card("ni", "tu, toi").save();

        Card ni = Card.find("byFront", "ni").first();

        assertNotNull(ni);
        assertEquals("tu, toi", ni.back);
    }

}
