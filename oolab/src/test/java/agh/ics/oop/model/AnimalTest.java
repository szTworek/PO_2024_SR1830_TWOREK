package agh.ics.oop.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import agh.ics.oop.Simulation;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimalTest {
//    @Test public void testAnimal3Lab() {
//    //    czy zwierze ma właściwą orientacje
//        List<Vector2d> startingPositions1= new ArrayList<Vector2d>(Arrays.asList(new Vector2d(2,3),new Vector2d(1,4)));
//        String[] args=new String[]{"r","l"};
//        List<MoveDirection> listOfMoves1 = OptionsParser.parse(args);
//        Simulation simulation1=new Simulation(startingPositions1,listOfMoves1);
//        List<Animal>animals1= simulation1.animals;
//
//
//        Animal animal1=animals1.get(0);
//        Animal animal2=animals1.get(1);
//        assertEquals("(2,3); Polnoc", animal1.toString());
//        assertEquals("(1,4); Polnoc", animal2.toString());
//
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,3); Wschod", animal1.toString());
//        assertEquals("(1,4); Zachod", animal2.toString());
//
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,3); Poludnie", animal1.toString());
//        assertEquals("(1,4); Poludnie", animal2.toString());
//
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,3); Zachod", animal1.toString());
//        assertEquals("(1,4); Wschod", animal2.toString());
//
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,3); Polnoc", animal1.toString());
//        assertEquals("(1,4); Polnoc", animal2.toString());
//
////        czy przemieszcza sie właściwie
//        String[] args2= new String[]{"f","b"};
//
//        simulation1.listOfMoves=OptionsParser.parse(args2);
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,4); Polnoc", animal1.toString());
//        assertEquals("(1,3); Polnoc", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        simulation1.listOfMoves=OptionsParser.parse(args2);
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(3,4); Wschod", animal1.toString());
//        assertEquals("(2,3); Zachod", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        simulation1.listOfMoves=OptionsParser.parse(args2);
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(3,3); Poludnie", animal1.toString());
//        assertEquals("(2,4); Poludnie", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        simulation1.listOfMoves=OptionsParser.parse(args2);
//        simulation1.run();
//        animal1=animals1.get(0);
//        animal2=animals1.get(1);
//        assertEquals("(2,3); Zachod", animal1.toString());
//        assertEquals("(1,4); Wschod", animal2.toString());
//
////        czy nie wychodzi poza mapę
//        List<Animal> animals2= new ArrayList<>(Arrays.asList(new Animal(new Vector2d(0,0)), new Animal(new Vector2d(4,4))));
//        simulation1.animals=animals2;
//        String[] args3=new String[]{"b","f"};
//        simulation1.listOfMoves=OptionsParser.parse(args3);
//        simulation1.run();
//
//        animal1=animals2.get(0);
//        animal2=animals2.get(1);
//        assertEquals("(0,0); Polnoc", animal1.toString());
//        assertEquals("(4,4); Polnoc", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        args3[1]="b";
//        simulation1.listOfMoves=OptionsParser.parse(args3);
//        simulation1.run();
//        animal1=animals2.get(0);
//        animal2=animals2.get(1);
//        assertEquals("(0,0); Wschod", animal1.toString());
//        assertEquals("(4,4); Zachod", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        args3[0]="f";
//        simulation1.listOfMoves=OptionsParser.parse(args3);
//        simulation1.run();
//        animal1=animals2.get(0);
//        animal2=animals2.get(1);
//        assertEquals("(0,0); Poludnie", animal1.toString());
//        assertEquals("(4,4); Poludnie", animal2.toString());
//
//        simulation1.listOfMoves=OptionsParser.parse(args);
//        simulation1.run();
//        args3[1]="f";
//        simulation1.listOfMoves=OptionsParser.parse(args3);
//        simulation1.run();
//        animal1=animals2.get(0);
//        animal2=animals2.get(1);
//        assertEquals("(0,0); Zachod", animal1.toString());
//        assertEquals("(4,4); Wschod", animal2.toString());
//
////       czy dane wejsciowe podane jako tablica znakow sa poprawnie interpretowane
//
//        String[] args4=new String[]{"abc","ijk","b","aaa"};
//        simulation1.listOfMoves=OptionsParser.parse(args4);
//        simulation1.animals.clear();
//        simulation1.animals.add(new Animal(new Vector2d(2,2)));
//        Animal animal3=simulation1.animals.get(0);
//
//        simulation1.run();
//        animal3=simulation1.animals.get(0);
//        assertEquals("(2,1); Polnoc", animal3.toString());
//        args4=new String[]{};
//        simulation1.listOfMoves=OptionsParser.parse(args4);
//        simulation1.run();
//        animal3=simulation1.animals.get(0);
//        assertEquals("(2,1); Polnoc", animal3.toString());
//
////        ##########testy2
//
//
//
//
//
//}}
    @Test
    public void animalCreatedHasNorthDirectionAndIsAt2_2Position(){
        //when
        Animal animal1 = new Animal();
        //then
        assertEquals("N",animal1.toString());
        assertEquals(new Vector2d(2,2),animal1.getPosition());
    }

}
