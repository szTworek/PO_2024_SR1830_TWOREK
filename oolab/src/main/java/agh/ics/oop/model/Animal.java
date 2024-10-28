package agh.ics.oop.model;
import static agh.ics.oop.model.MapDirection.*;

public class Animal {
    private MapDirection direction=NORTH;
    private Vector2d position;
    public Animal(Vector2d position){
        this.position = position;
    }
    public Animal(){
        this(new Vector2d(2,2));
    }
    public String toString(){
       return "("+this.position.getX()+","+this.position.getY()+"); "+ this.direction;
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d forward=null;
        Vector2d backward=null;
        switch(this.direction){
            case NORTH -> {forward=new Vector2d(0,1); backward=new Vector2d(0,-1);}
            case SOUTH -> {forward=new Vector2d(0,-1); backward=new Vector2d(0,1);}
            case EAST -> {forward=new Vector2d(1, 0); backward=new Vector2d(-1, 0);}
            case WEST -> {forward=new Vector2d(-1,0); backward=new Vector2d(1,0);}
        }
        switch (direction){
            case RIGHT -> this.direction= this.direction.next();
            case LEFT -> this.direction= this.direction.previous();
            case FORWARD -> this.position=this.position.add(forward);
            case BACKWARD -> this.position=this.position.add(backward);
        };
        switch (position.getX()){
            case -1 -> {position=new Vector2d(0, position.getY());}
            case 5 -> {position=new Vector2d(4, position.getY());}
        }
        switch (position.getY()){
            case -1 -> {position=new Vector2d(position.getX(), 0);}
            case 5 -> {position=new Vector2d(position.getX(), 4);}
        }
    }





}
