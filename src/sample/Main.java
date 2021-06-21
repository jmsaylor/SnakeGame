package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import snake.Cell;
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

        scene.setOnKeyPressed(keyEvent -> {
            var code = keyEvent.getCode();
            snake.setDirection(code);
        });

        primaryStage.setScene(scene);
        root.getChildren().add(canvas);

        new AnimationTimer() {

            @Override
            public void handle(long l) {
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

}
