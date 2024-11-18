package agh.ics.oop.model;

import agh.ics.oop.model.until.MapVisualizer;

import java.util.HashMap;
import java.util.Map;

import static agh.ics.oop.model.MoveDirection.*;
import static java.util.function.Predicate.not;

public class RectangularMap implements WorldMap {
    private Map<Vector2d, Animal> animals = new HashMap<>();
    private int width;
    private int height;
    MapVisualizer mapVisualizer=new MapVisualizer(this);
    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean place(Animal animal) {
        if (null==animals.get(animal.getPosition())){
            animals.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (animal==animals.get(animal.getPosition())){
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            Vector2d newPosition=animal.getPosition();
            animals.put(newPosition, animal);

        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (null!=animals.get(position)) {
            return true;
        }
        return false;
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(!isOccupied(position) && -1<position.getX() && position.getX()<width && -1<position.getY() && position.getY()<height) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(new Vector2d(0,0),new Vector2d(width-1,height-1));
    }
}
