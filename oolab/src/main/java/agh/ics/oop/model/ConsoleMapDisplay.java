package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int howManyMessages=0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        howManyMessages++;
        System.out.println(message);
        System.out.println(worldMap.toString());

    }
}
