package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import agh.ics.oop.OptionsParser;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OptionsParserTest {
    @Test public void test(){
        String[] args = {"f", "b", "r", "l"};
        List<MoveDirection> expected = new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT));
        List<MoveDirection> result = OptionsParser.modify(args);
        assertEquals(expected, result);

        String[] args2 = {"b", "r", "oo", "z","f"};
        List<MoveDirection> expected2 = new ArrayList<>(Arrays.asList(MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD));
        List<MoveDirection> result2 = OptionsParser.modify(args2);
        assertEquals(expected2, result2);
    }
}
