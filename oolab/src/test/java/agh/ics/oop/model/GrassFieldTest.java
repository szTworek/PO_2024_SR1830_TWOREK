package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {
    @Test
    public void grassCorrectlyPlacingOnMap(){
        //when
        WorldMap map= new GrassField(5);
        //then
        Vector2d lowerLeft= new Vector2d(0,0);
        Vector2d upperRight= new Vector2d((int)Math.sqrt(5*10),(int) Math.sqrt(5*10));
        Collection<WorldElement> receivedElements = map.getElements();

        //size
        assertEquals(receivedElements.size(), 5);

        //not outside map
        for (WorldElement element : receivedElements) {
            Vector2d position=element.getPosition();
            assertEquals(lowerLeft, position.lowerLeft(lowerLeft));
            assertEquals(upperRight, position.upperRight(upperRight));
        }

    }
    @Test
    public void isOccupied(){
        //when
        WorldMap map= new GrassField(1);
        //then
        Collection<WorldElement> receivedCollection = map.getElements();
        WorldElement element = receivedCollection.iterator().next();
        assertTrue(map.isOccupied(element.getPosition()));
    }

    @Test
    public void objectIsAt(){
        //when
        WorldMap map= new GrassField(1);
        //then
        Collection<WorldElement> receivedCollection = map.getElements();
        WorldElement element = receivedCollection.iterator().next();
        assertEquals(element,map.objectAt(element.getPosition()));
    }
}