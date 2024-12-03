package agh.ics.oop.model;

import agh.ics.oop.model.until.MapVisualizer;

import java.util.*;

public abstract class AbstractWorldMap implements WorldMap {
    protected List<MapChangeListener> listeners= new ArrayList<>();
    protected Map<Vector2d, Animal> animals = new HashMap<Vector2d, Animal>();
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);
    protected UUID mapID=UUID.randomUUID();


    public boolean canMoveTo(Vector2d position){
        return !animals.containsKey(position);
    }

    @Override
    public boolean place(Animal animal) throws IncorrectPositionException {
        if (null == animals.get(animal.getPosition())) {
            animals.put(animal.getPosition(), animal);
            mapChanged("Animal placed at position " + animal.getPosition());
            return true;
        } else {
            throw new IncorrectPositionException(animal.getPosition());
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {
        if (this.isOccupied(animal.getPosition())) {
            animals.remove(animal.getPosition());
            animal.move(direction, this);
            animals.put(animal.getPosition(), animal);
            mapChanged("Animal moved at "+animal.getPosition() );
        }
    }

    @Override
    public  String toString(){
        return mapVisualizer.draw(this.getCurrentBounds().LowerLeft(), this.getCurrentBounds().UpperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position){
        return animals.get(position);
    }

    @Override
    public Collection<WorldElement> getElements() {
        return new ArrayList<>(animals.values());
    }


    public abstract Boundary getCurrentBounds();

    public void addListener(MapChangeListener listener) {
        listeners.add(listener);
    }
    public void removeListener(MapChangeListener listener) {
        listeners.remove(listener);
    }

    public void mapChanged(String message) {
        for (MapChangeListener listener : listeners) {
            listener.mapChanged(this, message);
        }
    }

    @Override
    public UUID getID() {
        return mapID;
    }
}
