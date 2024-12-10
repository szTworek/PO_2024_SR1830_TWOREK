package agh.ics.oop.model;

public class ConsoleMapDisplay implements MapChangeListener{
    private int howManyMessages=1;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        synchronized (System.out) {
            System.out.println("message number: " + howManyMessages);
            System.out.println("mapID: " + worldMap.getID());
            System.out.println(message);
            System.out.println(worldMap);
            howManyMessages++;
        }
    }
}
