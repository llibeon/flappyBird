import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.security.Key;

/**
 * Created by Leanyka on 02/10/16.
 */
public class Helloworldproject extends Application {
    private double linnuKorgus = 0;
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage theStage) {
        theStage.setTitle("Flappy Bird");
        Group root = new Group();
        Scene theScene = new Scene(root);
        theStage.setScene(theScene);
        Canvas canvas = new Canvas(1000, 600);
        root.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);
        Font theFont = Font.font("Times New Roman", FontWeight.MEDIUM, 48);
        gc.setFont(theFont);
        gc.fillText("Flappy Bird", 60, 50);
        gc.strokeText("Flappy Bird", 60, 50);
        Image bird = new Image("bird.png");
        Image space = new Image("space.png");
        final long startNanoTime = System.nanoTime();
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                // background image clears canvas
                gc.drawImage(space, 0, 0);
                linnuKorgus = linnuKorgus + 10;
                gc.drawImage(bird, 10, linnuKorgus);

            }
        }.start();
        theStage.show();

        theScene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.RIGHT) {
                linnuKorgus++;
            } else if (code == KeyCode.LEFT) {
                linnuKorgus--;
            } else if (code == KeyCode.UP) {
                linnuKorgus = -10;
            }

        });


    }
}
