package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;
import agh.ics.oop.OptionsParser;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class OptionsParserTest {
    @Test public void test(){
        String[] args = {"f", "b", "r", "l"};
        MoveDirection[] expected = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        MoveDirection[] result = OptionsParser.modify(args);
        assertArrayEquals(expected, result);

        String[] args2 = {"b", "r", "oo", "z","f"};
        MoveDirection[] expected2 = {MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.FORWARD};
        MoveDirection[] result2 = OptionsParser.modify(args2);
        assertArrayEquals(expected2, result2);
    }
}
