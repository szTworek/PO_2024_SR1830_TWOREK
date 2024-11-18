package agh.ics.oop.model;
import static agh.ics.oop.model.MapDirection.*;

public class Animal{
    private MapDirection direction=NORTH;
    private Vector2d position;

    public Animal(Vector2d position){
        this.position = position;
    }
    public Animal(){
        this(new Vector2d(2,2));
    }

    public Vector2d getPosition() {
        return position;
    }

    public String toString(){
        switch(direction){
            case NORTH:
                return "N";
                case EAST:
                    return "E";
                    case SOUTH:
                        return "S";
                        case WEST:
                            return "W";
                            default:
                                return "";
        }
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction, MoveValidator validator){
        Vector2d forward=null;
        Vector2d backward=null;
        Vector2d newPosition=null;
        switch(this.direction){
            case NORTH -> {forward=new Vector2d(0,1); backward=new Vector2d(0,-1);}
            case SOUTH -> {forward=new Vector2d(0,-1); backward=new Vector2d(0,1);}
            case EAST -> {forward=new Vector2d(1, 0); backward=new Vector2d(-1, 0);}
            case WEST -> {forward=new Vector2d(-1,0); backward=new Vector2d(1,0);}
        }
        switch (direction){
            case RIGHT -> this.direction= this.direction.next();
            case LEFT -> this.direction= this.direction.previous();
            case FORWARD -> newPosition=this.position.add(forward);
            case BACKWARD -> newPosition=this.position.add(backward);
        };

        if (newPosition!=null && validator.canMoveTo(newPosition)){
            this.position=newPosition;
        }
    }





}
