package agh.ics.oop.model;
import agh.ics.oop.model.until.MapVisualizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.*;

public class GrassField extends AbstractWorldMap implements WorldMap{
    private Vector2d limitUR;
    private Vector2d limitLL;
    private final Random randomPlace = new Random();

    public GrassField(int fields) {
        limitUR=new Vector2d(0,0);
        limitLL=new Vector2d((int)Math.sqrt(fields*10),(int) Math.sqrt(fields*10));
        placeGrass(fields);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position) || grass.containsKey(position);
    }
    @Override
    public String toString() {
        upperRight = limitUR;
        lowerLeft = limitLL;
        for (Vector2d position : animals.keySet()) {
            upperRight = upperRight.upperRight(position);
            lowerLeft = lowerLeft.lowerLeft(position);
        }
        return super.toString();
    }

    private void placeGrass (int fields){
        while (grass.size() < fields) {
            int x = randomPlace.nextInt(1 + (int) Math.sqrt(fields * 10));
            int y = randomPlace.nextInt(1 + (int) Math.sqrt(fields * 10));
            Vector2d newPosition = new Vector2d(x, y);
            if (!grass.containsKey(newPosition)) {
                grass.put(newPosition, new Grass(newPosition));
                limitUR = limitUR.upperRight(newPosition);
                limitLL = limitLL.lowerLeft(newPosition);
            }
        }
    }
}


