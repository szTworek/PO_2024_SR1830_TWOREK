package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.List;


public class World {
    public static void main(String[] args){
        List<MoveDirection> directions = OptionsParser.parse(args);
        AbstractWorldMap map=new GrassField(3);
        map.addListener(new ConsoleMapDisplay());
        List<Vector2d> positions = List.of(new Vector2d(-1, -1), new Vector2d(1, 0), new Vector2d(1, 1));
        Simulation simulation = new Simulation(positions, directions,map);
        simulation.run();

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

