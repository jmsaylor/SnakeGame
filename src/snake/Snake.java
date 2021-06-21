package snake;

import javafx.scene.input.KeyCode;
import util.Cell;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    int length = 10;
    KeyCode direction = KeyCode.UP;
    Cell head = new Cell(250, 250);
    LinkedList<Cell> body = new LinkedList<>();

    public Snake() {
        int start = 250;
        for (int i = 0; i < length - 1; i++) {
            body.addLast(new Cell(250, start += 10));
        }
    }

    public List<Cell> grow() {
            body.addFirst(head);
            switch (direction) {
                case UP:
                    head = new Cell(head.getX(), head.getY() - 10);
                    break;
                case DOWN:
                    head = new Cell(head.getX(), head.getY() + 10);
                    break;
                case LEFT:
                    head = new Cell(head.getX() - 10, head.getY());
                    break;
                case RIGHT:
                    head = new Cell(head.getX() + 10, head.getY());
                    break;
            }
            body.addLast(body.peekLast().clone());
            body.addLast(body.peekLast().clone());
            body.addLast(body.peekLast().clone());
            body.addLast(body.peekLast().clone());
            body.addLast(body.peekLast().clone());

            return List.of(head, body.peekLast());

        }

    public List<Cell> move() {
        body.addFirst(head);
        switch (direction) {
            case UP:
                head = new Cell(head.getX(), head.getY() - 10);
                break;
            case DOWN:
                head = new Cell(head.getX(), head.getY() + 10);
                break;
            case LEFT:
                head = new Cell(head.getX() - 10, head.getY());
                break;
            case RIGHT:
                head = new Cell(head.getX() + 10, head.getY());
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

    public int getHeadX() {
        return head.getX();
    }

    public int getHeadY() {
        return head.getY();
    }
}
