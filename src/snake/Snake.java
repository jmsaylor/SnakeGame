package snake;

import javafx.scene.input.KeyCode;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    int length = 3;
    KeyCode direction = KeyCode.UP;
    Cell head = new Cell(250, 250);
    LinkedList<Cell> body = new LinkedList<>();

    public void grow() {
        length++;
    }

    public List<Cell> move() {
        body.addFirst(head);
        switch (direction) {
            case UP:
                head = new Cell(head.x, head.y - 10);
                break;
            case DOWN:
                head = new Cell(head.x, head.y + 10);
                break;
            case LEFT:
                head = new Cell(head.x - 10, head.y);
                break;
            case RIGHT:
                head = new Cell(head.x + 10, head.y);
                break;
        }

        return List.of(head, body.removeLast());

    }

    public void setDirection(KeyCode direction) {
        this.direction = direction;
    }

    public int getLength(){
        return length;
    }
}
