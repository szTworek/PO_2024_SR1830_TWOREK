package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] modify(String[] args){
        int len=args.length;
        MoveDirection[] moves = new MoveDirection[len];
        int i=0;
        for (String argument : args) {
                MoveDirection direction = switch (argument) {
                    case "f" -> MoveDirection.FORWARD;
                    case "b" -> MoveDirection.BACKWARD;
                    case "r" -> MoveDirection.RIGHT;
                    case "l" -> MoveDirection.LEFT;
                    default -> MoveDirection.UNKNOWN;
                };
                if (direction!=MoveDirection.UNKNOWN){
                    moves[i] = direction;
                    i++;
                }
            }
        return Arrays.copyOfRange(moves, 0, i);
    }


}
