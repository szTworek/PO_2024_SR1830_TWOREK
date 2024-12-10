package agh.ics.oop;
import agh.ics.oop.model.*;

import java.util.ArrayList;
import java.util.List;


public class World {
    public static void main(String[] args){
        try {
            List<Simulation> simulations = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                List<MoveDirection> directions = OptionsParser.parse(args);
                AbstractWorldMap map1 = new GrassField(3);
                map1.addListener(new ConsoleMapDisplay());
                List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(1, 0), new Vector2d(1, 1));
                Simulation simulation1 = new Simulation(positions, directions, map1);
                simulations.add(simulation1);
            }
            SimulationEngine engine = new SimulationEngine(simulations);

            //        engine.runSync();
            engine.runAsyncInThreadPool();
            try {
                engine.awaitSimulationsEnd();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println("system zakonczyl dzialanie");
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }

    }
//    public static void run(List<MoveDirection> args){
//       for(MoveDirection argument : args ){
//            String message = switch (argument) {
//                case FORWARD -> "zwierzak idzie do przodu";
//                case BACKWARD -> "zwierzak idzie do tyłu";
//                case RIGHT -> "zwierzak skreca w prawo";
//                case LEFT -> "zwierzak skreca w lewo";
//            };
//
//            System.out.println(message);
//        }
//    }

}

