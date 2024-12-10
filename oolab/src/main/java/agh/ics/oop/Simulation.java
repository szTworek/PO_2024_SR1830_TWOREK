package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.ArrayList;

import java.util.List;

public class Simulation implements Runnable {
    private List<Animal>animals= new ArrayList<>();
    private List<MoveDirection> listOfMoves= new ArrayList<>();
    private WorldMap worldMap;


    public Simulation(List<Vector2d> startingPositions, List<MoveDirection> listOfMoves, WorldMap worldMap) {
        this.worldMap=worldMap;
        for(Vector2d position: startingPositions){
            try{
                Animal newAnimal = new Animal(position);
                worldMap.place(newAnimal);
                animals.add(newAnimal);
            }catch(IncorrectPositionException e){
                System.out.println(e.getMessage());
            }
        }
        this.listOfMoves=listOfMoves;

    }

    public void setListOfMoves(List<MoveDirection> listOfMoves) {
        this.listOfMoves = listOfMoves;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
    public List<Animal> getAnimals(){
        return animals;
    }

    public void run(){

        for(int i=0; i<listOfMoves.size(); i++){
            int j = i%animals.size();
            Animal animal = animals.get(j);
            worldMap.move(animal,listOfMoves.get(i));
        }
    }
}
