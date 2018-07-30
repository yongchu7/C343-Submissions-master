package FloodIt;

import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class FloodFunction {
    private Driver driver;
    //here floodList is declared as a LinkedList
    //it is declared as public (a bad practice), but it is needed by the Driver class
    public List<Coord> floodList = new LinkedList<Coord>();
    
    //constructor  
    public FloodFunction(Driver newDriver) {
        driver = newDriver;
        //when the game starts, only the cell at the left/top corner is filled
        floodList.add(new Coord(0, 0));
    }
    
      public void flood(int colorToFlood) {
      for ( int i = 0; i < floodList.size(); i++) {
        Coord color = floodList.get(i);
        Coord up = up(color);
        Coord down = down(color);
        Coord left = left(color);
        Coord right = right(color);
        if (inbound(up) && (colorOfCoord(up) == colorToFlood) && !floodList.contains(up)) {
         floodList.add(up);
        }
        if (inbound(down) && (colorOfCoord(down) == colorToFlood) && !floodList.contains(down)) {
         floodList.add(down);
        }
        if (inbound(left) && (colorOfCoord(left) == colorToFlood) && !floodList.contains(left)) {
         floodList.add(left);
        }
        if (inbound(right) && (colorOfCoord(right) == colorToFlood) && !floodList.contains(right)) {
         floodList.add(right);
        }
      }
    }
    


    

    //is input cell (specified by coord) on the board?
    public boolean inbound(final Coord coord) {
        final int x = coord.x;
        final int y = coord.y;
        final int size = this.driver.size;
        return x > -1 && x < size && y > -1 && y < size;
    }
    //return the coordinate of the cell on the top of the given cell (coord) 
    public Coord up(final Coord coord) {
        return new Coord(coord.x, coord.y-1);
    }
    //return the coordinate of the cell below the given cell (coord)
    public Coord down(final Coord coord) {
        return new Coord(coord.x, coord.y+1);
    }
    //return the coordinate of the cell to the left of the given cell (coord)
    public Coord left(final Coord coord) {
        return new Coord(coord.x-1, coord.y);
    }
    //return the coordinate of the cell to the right of the given cell (coord)
    public Coord right(final Coord coord) {
        return new Coord(coord.x + 1, coord.y);
    }
    //get the color of a cell (coord)
    public int colorOfCoord(final Coord coord) {
        return this.driver.getColor(coord);
    }
    
   
    
}