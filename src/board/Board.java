package board;

import apple.Apple;
import snake.Snake;

public class Board {

    Snake snake;
    Apple apple;

    public Board(Snake snake, Apple apple) {
        this.snake = snake;
        this.apple = apple;
    }

    public boolean isAppleEaten() {
        return (snake.getHeadX() > apple.getX() - 10 && snake.getHeadX() < apple.getX() + 10
        && snake.getHeadY() > apple.getY() - 10 && snake.getHeadY() < apple.getY() + 10);
    }
}
