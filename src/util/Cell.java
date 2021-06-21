package util;

public class Cell implements Cloneable {
    int x;
    int y;

    public Cell(int x, int y) {
        if (x > 500) x = 0;
        if (x < 0) x = 500;
        if (y > 500) y = 0;
        if (y < 0) y = 500;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Cell clone() {
        return new Cell(x, y);
    }
}
