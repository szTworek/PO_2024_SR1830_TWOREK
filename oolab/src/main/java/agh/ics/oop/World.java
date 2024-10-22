package agh.ics.oop;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MoveDirection;




public class World {
    public static void main(String[] args){
        MoveDirection[] moves=OptionsParser.modify(args);
        System.out.println("Start");
        World.run(moves);
        System.out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection direction=MapDirection.EAST;
        System.out.println(direction.next());
        System.out.println(direction.previous());
        System.out.println(direction.toUnitVector());

    }
    public static void run(MoveDirection[] args){
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

