import org.junit.*;

import java.util.*;

import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void createAndRetrieveCard() {
        Card.newCard("ni", "tu, toi").save();

        Card ni = Card.find("byFront", "ni").first();

        assertNotNull(ni);
        assertEquals("tu, toi", ni.back);
    }

    @Test
    public void createAndRetrieveCardWithCache() {
        Card.newCard("ni", "tu, toi").save();

        Card ni = Card.find("byFront", "ni").first();
        ni.turnOver();
        Card ni2 = Card.find("byFront", "ni").first();
        assertSame(ni, ni2);
        assertEquals(ni2.getAnswer(), ni.getAnswer());
    }

    @Test
    public void createAndRetrieveCardWithCacheFindById() {
        Card.newCard("ni", "tu, toi").save();

        Card ni = Card.find("byFront", "ni").first();
        ni.turnOver();
        Card ni2 = Card.findById(ni.getId());
        assertSame(ni, ni2);
        assertEquals(ni2.getAnswer(), ni.getAnswer());
    }

}
