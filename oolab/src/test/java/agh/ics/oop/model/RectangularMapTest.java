package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    @Test
    public void placingAnimalOnMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal();
        boolean result=false;
        //when
        try {
            result = map.place(animal);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }

        //then
        assertTrue(result);
    }
//    @Test
//    public void cannotPlaceAnimalsInTheSamePosition() {
//        //given
//        RectangularMap map=new RectangularMap(5,5);
//        Animal animal1=new Animal();
//        Animal animal2=new Animal();
//        boolean result1=false;
//        boolean result2=true;
//        //when
//        try {
//            result1 = map.place(animal1);
//            result2 = map.place(animal2);
//        } catch (IncorrectPositionException e) {
//            fail(e.getMessage());
//        }
//
//        //then
//        assertTrue(result1);
//        assertFalse(result2);
//    }
    @Test
    public void positionIsOccupied() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1=new Animal();
        try {
            map.place(animal1);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }
        //when
        boolean result=map.isOccupied(new Vector2d(2,2));
        //then
        assertTrue(result);
    }
    @Test
    public void positionIsNotOccupied() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        //when
        boolean result=map.isOccupied(new Vector2d(2,2));
        //then
        assertFalse(result);
    }
    @Test
    public void objectIsAt(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal();
        try {
            map.place(animal);
        }catch (IncorrectPositionException e){
            fail(e.getMessage());
        }
        //when
        WorldElement result=map.objectAt(new Vector2d(2,2));
        //then
        assertEquals(animal,result);
    }
    @Test
    public void objectIsNotAt(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        //when
        WorldElement result=map.objectAt(new Vector2d(2,2));
        //then
        assertNull(result);
    }
    @Test
    public void animalCanMoveToNotOccupiedPositionOnMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        //when
        boolean result=map.canMoveTo(new Vector2d(2,2));
        //then
        assertTrue(result);

    }
    @Test
    public void animalCannotMoveToOccupiedPositionOnMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal();
        try {
            map.place(animal);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }

        //when
        boolean result=map.canMoveTo(new Vector2d(2,2));
        //then
        assertFalse(result);

    }
    @Test
    public void animalCannotMoveToPositionOutsideMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        //when
        boolean result=map.canMoveTo(new Vector2d(6,2));
        //then
        assertFalse(result);
    }
    @Test
    public void movedAnimalIsInNewPosition() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal();
        try {
            map.place(animal);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }

        MoveDirection direction=MoveDirection.FORWARD;
        //when
        map.move(animal,direction);
        Vector2d result=animal.getPosition();
        //then
        assertEquals(new Vector2d(2,3), result);
    }
    @Test
    public void animalDoesNotMoveOutsideMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal(new Vector2d(4,4));
        try {
            map.place(animal);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }
        MoveDirection direction=MoveDirection.FORWARD;
        //when
        map.move(animal,direction);
        Vector2d result=animal.getPosition();
        //then
        assertEquals(new Vector2d(4,4), result);
    }
    @Test
    public void animalDoesNotMoveToOccupiedPosition(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,1));
        try {
            map.place(animal1);
            map.place(animal2);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }
        MoveDirection direction=MoveDirection.FORWARD;
        //when
        map.move(animal2,direction);
        Vector2d result=animal2.getPosition();
        //then
        assertEquals(new Vector2d(2,1), result);
    }
    @Test
    public void animalChangesItsDirection(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1=new Animal();
        try {
            map.place(animal1);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }
        MoveDirection direction=MoveDirection.RIGHT;
        //when
        map.move(animal1,direction);
        //then
        assertEquals("E",animal1.toString());
    }

    @Test
    public void gettingElements(){
        WorldMap map=new GrassField(2);
        Animal animal1=new Animal();
        Animal animal2=new Animal(new Vector2d(2,1));
        //when
        try {
            map.place(animal1);
            map.place(animal2);
        }catch(IncorrectPositionException e){
            fail(e.getMessage());
        }
        //then
        Collection<WorldElement> receivedCollection = map.getElements();

        assertEquals(receivedCollection.size(), 4);
        for (WorldElement element : receivedCollection) {
            if(element instanceof Animal){
                if(element.getPosition().equals(new Vector2d(2,2))){
                    assertEquals(animal1,element);
                }
                else{
                    assertEquals(animal2,element);
                }
            }
        }

    }


//    @Test
//    public void correctVisualisation(){
//        //given
//        WorldMap map=new RectangularMap(5,5);
//        try {
//            map.place(new Animal(new Vector2d(1, 1)));
//            map.place(new Animal(new Vector2d(0, 0)));
//        }catch(IncorrectPositionException e){
//            fail(e.getMessage());
//        }
//        //when
//        String visualisation=map.toString();
//        //then
//        String expected =
//                "y\\x  0 1 2 3 4\n" +
//                "  5: -----------\n" +
//                "  4: | | | | | |\n" +
//                "  3: | | | | | |\n" +
//                "  2: | | | | | |\n" +
//                "  1: | |N| | | |\n" +
//                "  0: |N| | | | |\n" +
//                " -1: -----------";
//        assertEquals(expected.trim(),visualisation.trim());
//    }





}
