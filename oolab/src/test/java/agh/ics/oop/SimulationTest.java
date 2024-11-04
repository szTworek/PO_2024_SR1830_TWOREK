package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SimulationTest {
    @Test
    void animalsMovesToCorrectPositions() {
        //given
        List<Vector2d> startingPositions = new ArrayList<Vector2d>(Arrays.asList(new Vector2d(2, 2), new Vector2d(1, 1)));
        List<MoveDirection> listOfMoves = new ArrayList<MoveDirection>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD));
        WorldMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(startingPositions, listOfMoves, map);
        //when
        simulation.run();
        //then
        Vector2d expectedPosition1 = new Vector2d(2, 4);
        Vector2d expectedPosition2 = new Vector2d(1, 3);
        List<Animal> animals = simulation.getAnimals();
        Animal animal1 = animals.get(0);
        Animal animal2 = animals.get(1);
        Vector2d receivedPosition1 = animal1.getPosition();
        Vector2d receivedPosition2 = animal2.getPosition();

        assertEquals(expectedPosition1, receivedPosition1);
        assertEquals(expectedPosition2, receivedPosition2);
    }
    @Test
    void animalDoesNotMoveToIncorrectPosition() {
        //given
        List<Vector2d> startingPositions = new ArrayList<Vector2d>(Arrays.asList(new Vector2d(1, 2), new Vector2d(1, 1)));
        List<MoveDirection> listOfMoves = new ArrayList<MoveDirection>(Arrays.asList(MoveDirection.BACKWARD));
        WorldMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(startingPositions, listOfMoves, map);
        //when
        simulation.run();
        //then
        Vector2d expectedPosition1 = new Vector2d(1, 2);
        List<Animal> animals = simulation.getAnimals();
        Animal animal1 = animals.get(0);
        Vector2d receivedPosition1 = animal1.getPosition();
        assertEquals(expectedPosition1, receivedPosition1);




    }

}