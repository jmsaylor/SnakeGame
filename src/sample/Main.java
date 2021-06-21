package sample;

import apple.Apple;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import util.Cell;
import snake.Snake;

import java.util.List;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Snake");
        Group root = new Group();

        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0,0,500, 500);

        Scene scene = new Scene(root);

        Snake snake = new Snake();
        Apple apple = new Apple();
        drawApple(gc, apple.getLocation());

        scene.setOnKeyPressed(keyEvent -> {
            var code = keyEvent.getCode();
            snake.setDirection(code);
        });

        primaryStage.setScene(scene);
        root.getChildren().add(canvas);

        new AnimationTimer() {

            @Override
            public void handle(long l) {
                if (snake.getHeadX() == apple.getX() && snake.getHeadY() == apple.getY()) {
                    List<Cell> locations = apple.changeLocation();
                    drawApple(gc, locations.get(0), locations.get(1));
                }
                draw(gc, snake, l);

            }
        }.start();


        primaryStage.show();

    }

    public void draw(GraphicsContext gc, Snake snake, long time) {
        List<Cell> cells = snake.move();
        Cell head = cells.get(0);
        Cell tail = cells.get(1);
        gc.setFill(Color.BLANCHEDALMOND);
        gc.fillRect(head.getX(), head.getY(), 10, 10);
        gc.setFill(Color.BLACK);
        gc.fillRect(tail.getX(), tail.getY(), 10, 10);
    }

    public void drawApple(GraphicsContext gc, Cell oldLocation, Cell newLocation) {
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(newLocation.getX(), newLocation.getY(), 10, 10);
        gc.setFill(Color.BLACK);
        gc.fillRect(oldLocation.getX(), oldLocation.getY(), 10, 10);
    }

    public void drawApple(GraphicsContext gc, Cell newLocation) {
        gc.setFill(Color.BLUEVIOLET);
        gc.fillRect(newLocation.getX(), newLocation.getY(), 10, 10);
    }

}
