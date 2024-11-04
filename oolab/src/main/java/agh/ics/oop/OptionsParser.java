package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> modify(String[] args){
        List<MoveDirection> moves = new ArrayList<>();
        for (String argument : args) {
                switch (argument) {
                    case "f" -> moves.add(MoveDirection.FORWARD);
                    case "b" -> moves.add(MoveDirection.BACKWARD);
                    case "r" -> moves.add(MoveDirection.RIGHT);
                    case "l" -> moves.add(MoveDirection.LEFT);
                    default -> {continue;}

                };
            }
        return moves;
    }


}
