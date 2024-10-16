package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args){
        MoveDirection[] moves=OptionsParser.modify(args);
        System.out.println("system wystartowal");
        World.run(moves);
        System.out.println("system zakonczyl dzialanie");
    }
    public static void run(MoveDirection[] args){
//        System.out.println("zwierzak idzie do przodu");
//        int i=0;
       for(MoveDirection argument : args ){
//            System.out.print(argument);
//            if (i < args.length - 1) {
//                System.out.print(", ");
//            }else{
//                System.out.println(" ");
//            }
//            i++;
            String message = switch (argument) {
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case RIGHT -> "zwierzak skreca w prawo";
                case LEFT -> "zwierzak skreca w lewo";
                default -> "Nieznana komenda";
            };

            System.out.println(message);
        }
    }
}

