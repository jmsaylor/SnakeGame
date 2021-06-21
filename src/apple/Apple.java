package apple;

import util.Cell;

import java.util.List;
import java.util.Random;

public class Apple {
    private static Random random = new Random();

    Cell location;

    public Apple() {
        this.location = new Cell(random.nextInt(500), random.nextInt(500));
    }

    public List<Cell> changeLocation() {
        Cell oldLocation = location;
        location = new Cell(random.nextInt(500), random.nextInt(500));
        return List.of(oldLocation, location);
    }

    public int getX() {
        return location.getX();
    }

    public int getY() {
        return location.getY();
    }

    public Cell getLocation() {
        return location;
    }
}
