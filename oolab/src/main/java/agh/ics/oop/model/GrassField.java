package agh.ics.oop.model;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap implements WorldMap{
    private Map<Vector2d, Grass> grass = new HashMap<Vector2d, Grass>();
    private Vector2d grassFieldLimitUR;
    private Vector2d grassFieldLimitLL;
    private final Random randomPlace = new Random();
    private final int upperLimit;


    public GrassField(int fields) {
        grassFieldLimitUR=new Vector2d(0,0);
        upperLimit=1+(int)Math.sqrt(fields*10);
        grassFieldLimitLL =new Vector2d(upperLimit,upperLimit);
        placeGrass(fields);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grass.containsKey(position);
    }

    private void placeGrass (int fields){
        while (grass.size() < fields) {
            int x = randomPlace.nextInt(upperLimit);
            int y = randomPlace.nextInt(upperLimit);
            Vector2d newPosition = new Vector2d(x, y);
            if (!grass.containsKey(newPosition)) {
                grass.put(newPosition, new Grass(newPosition));
                grassFieldLimitUR = grassFieldLimitUR.upperRight(newPosition);
                grassFieldLimitLL = grassFieldLimitLL.lowerLeft(newPosition);
            }
        }
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (super.objectAt(position) == null) {
            return grass.get(position);
        }
        else{ return super.objectAt(position); }
    }

    @Override
    public Collection<WorldElement> getElements(){
        Collection<WorldElement> elements = super.getElements();
        elements.addAll(grass.values());
        return elements;
    }

    @Override
    public Boundary getCurrentBounds() {
        Vector2d upperRight = grassFieldLimitUR;
        Vector2d lowerLeft = grassFieldLimitLL;
        for (Vector2d position : animals.keySet()){
            upperRight = upperRight.upperRight(position);
            lowerLeft = lowerLeft.lowerLeft(position);
        }
        return new Boundary(lowerLeft, upperRight);
    }
}


