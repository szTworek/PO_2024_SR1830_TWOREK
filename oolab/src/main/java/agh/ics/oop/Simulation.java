package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;

import java.util.List;

public class Simulation {
//    komentarz dotyczący typu zaimplementowanych list:
//    w tym przypadku lepiej sprawdzają się ArrayList ponieważ istnieje konieczność odwoływania się do poszczególnych
//    elementów listy, ponadto elementy nie są usuwane badz dodawane w srodek listy, co mógłoby być ewentualnym czynnikiem
//    przemawiającym za LinkedList.
    public List<Animal>animals= new ArrayList<>();
    public List<MoveDirection> listOfMoves= new ArrayList<>();
    public Simulation(List<Vector2d> startingPositions, List<MoveDirection> listOfMoves){
        for(Vector2d position: startingPositions){
            animals.add(new Animal(position));
        }
        this.listOfMoves=listOfMoves;
    }
    public void run(){

        for(int i=0; i<listOfMoves.size(); i++){
            int j = i%animals.size();
            Animal animal = animals.get(j);
            animal.move(listOfMoves.get(i));
            System.out.println("Zwierze "+j+": "+ animal.toString());
        }
    }
}
