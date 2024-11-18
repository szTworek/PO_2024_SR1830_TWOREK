package agh.ics.oop.model;

import agh.ics.oop.model.until.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

import static agh.ics.oop.model.MoveDirection.*;
import static java.util.function.Predicate.not;

public class RectangularMap extends AbstractWorldMap implements WorldMap {

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width-1, height-1);
        lowerLeft = new Vector2d(0, 0);
    }
}
