package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;


public class World {
    public static void main(String[] args){
//        List<MoveDirection> moves=OptionsParser.modify(args);
//        System.out.println("Start");
//        World.run(moves);
//        System.out.println("Stop");
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        MapDirection direction=MapDirection.EAST;
//        System.out.println(direction.next());
//        System.out.println(direction.previous());
//        System.out.println(direction.toUnitVector());
//        Animal pies= new Animal();
//        System.out.println(pies);
        List<MoveDirection> directions = OptionsParser.parse(args);
        WorldMap map=new GrassField(5);
        List<Vector2d> positions = List.of(new Vector2d(0, 0), new Vector2d(1, 0), new Vector2d(1, 1));
        Simulation simulation = new Simulation(positions, directions,map);
        simulation.run();
        Animal animal=new Animal();
        map.place(animal);
        System.out.println(map);

    }
    public static void run(List<MoveDirection> args){
       for(MoveDirection argument : args ){
            String message = switch (argument) {
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case RIGHT -> "zwierzak skreca w prawo";
                case LEFT -> "zwierzak skreca w lewo";
            };

            System.out.println(message);
        }
    }

}

