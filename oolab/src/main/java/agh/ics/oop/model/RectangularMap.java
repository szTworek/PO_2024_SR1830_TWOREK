package agh.ics.oop.model;

import agh.ics.oop.model.until.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

import static agh.ics.oop.model.MoveDirection.*;
import static java.util.function.Predicate.not;

public class RectangularMap extends AbstractWorldMap implements WorldMap {
    protected Vector2d lowerLeft;
    protected Vector2d upperRight;

    public RectangularMap(int width, int height) {
        upperRight = new Vector2d(width-1, height-1);
        lowerLeft = new Vector2d(0, 0);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(upperRight) && !this.isOccupied(position);
    }
    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(lowerLeft, upperRight);
    }
}
