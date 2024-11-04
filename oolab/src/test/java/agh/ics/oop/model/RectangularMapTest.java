package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {
    @Test
    public void placingAnimalOnMap() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal=new Animal();

        //when
        boolean result=map.place(animal);

        //then
        assertTrue(result);
    }
    @Test
    public void cannotPlaceAnimalsInTheSamePosition() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1=new Animal();
        Animal animal2=new Animal();

        //when
        boolean result1=map.place(animal1);
        boolean result2=map.place(animal2);

        //then
        assertTrue(result1);
        assertFalse(result2);
    }
    @Test
    public void positionIsOccupied() {
        //given
        RectangularMap map=new RectangularMap(5,5);
        Animal animal1=new Animal();
        map.place(animal1);

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
        map.place(animal);
        //when
        Animal result=map.objectAt(new Vector2d(2,2));
        //then
        assertEquals(animal,result);
    }
    @Test
    public void objectIsNotAt(){
        //given
        RectangularMap map=new RectangularMap(5,5);
        //when
        Animal result=map.objectAt(new Vector2d(2,2));
        //then
        assertEquals(null,result);
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
        map.place(animal);
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
        map.place(animal);
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
        map.place(animal);
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
        map.place(animal1);
        map.place(animal2);
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
        map.place(animal1);
        MoveDirection direction=MoveDirection.RIGHT;
        //when
        map.move(animal1,direction);
        //then
        assertEquals("E",animal1.toString());
    }


}
