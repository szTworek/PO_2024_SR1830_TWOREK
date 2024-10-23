package agh.ics.oop.model;

import org.junit.jupiter.api.Test;
import agh.ics.oop.model.Vector2d;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test public void testVector2d() {
//        args
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(7,5);
        Vector2d v4 = new Vector2d(0,0);
        Vector2d v5 = new Vector2d(3,8);
//        equals
        assertTrue(v1.equals(v2));
//        toString
        assertEquals("(1,2)",v1.toString());
//        precedes
        assertTrue(v2.precedes(v1));
        assertFalse(v3.precedes(v1));
//        follows
        assertTrue(v1.follows(v4));
        assertFalse(v4.follows(v3));
//        upperRight
        assertEquals(new Vector2d(1,2),v1.upperRight(v2));
        assertEquals(new Vector2d(7,8),v5.upperRight(v3));
//        lowerLeft
        assertEquals(new Vector2d(3,5),v5.lowerLeft(v3));
//        add
        assertEquals(new Vector2d(10,13),v5.add(v3));
//        subtract
        assertEquals(new Vector2d(2,6),v5.subtract(v1));
//        opposite
        assertEquals(new Vector2d(2,1),v1.opposite());
    }
}
