package com.example.demo;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpriteSheetAnimation extends Application {

    private static String SPRITE_SHEET_URL;
    private static  int[] FRAME_COUNT = {4, 4, 4, 4, 4};
    private static  int[] FRAME_WIDTH = {64, 64, 110, 256, 100};

    private static  int[] FRAME_HEIGHT = {64, 64, 128, 256, 100};
    private static  int[] FRAME_DURATION_MILLIS = {100, 100, 100, 100, 100};

    private static int currentFrame = 0;

    public static void main(String[] args) {
        launch(args);
    }

    public static void help(Stage primaryStage) {
        primaryStage.setTitle("Sprite Sheet Animation");

        Button b = new Button("Human");
        Button b2 = new Button("Giant");
        Button b3 = new Button("Goblin");
        Button b4 = new Button("Dwarf");
        Button b5 = new Button("Vampire");

        FlowPane root = new FlowPane(50, 50);

        root.getChildren().addAll(b, b2, b3, b4, b5, new Label(""));

        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SPRITE_SHEET_URL = "Knight-Walk-Sheet.png";
                ImageView imageView = new ImageView(new Image(SPRITE_SHEET_URL));
                timeline(imageView, 0);
                root.getChildren().remove(root.getChildren().size()-1);
                root.getChildren().add(imageView);
            }
        });
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SPRITE_SHEET_URL = "Attack.png";
                ImageView imageView = new ImageView(new Image(SPRITE_SHEET_URL));
                timeline(imageView, 1);
                root.getChildren().remove(root.getChildren().size()-1);
                root.getChildren().add(imageView);
            }
        });
        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SPRITE_SHEET_URL = "Attack1.png";
                ImageView imageView = new ImageView(new Image(SPRITE_SHEET_URL));
                timeline(imageView, 2);
                root.getChildren().remove(root.getChildren().size()-1);
                root.getChildren().add(imageView);
            }
        });
        b4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SPRITE_SHEET_URL = "Attack2.png";

                ImageView imageView = new ImageView(new Image(SPRITE_SHEET_URL));
                timeline(imageView, 3);
                root.getChildren().remove(root.getChildren().size()-1);
                root.getChildren().add(imageView);
            }
        });
        b5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SPRITE_SHEET_URL = "attacking.png";

                ImageView imageView = new ImageView(new Image(SPRITE_SHEET_URL));
                timeline(imageView, 4);
                root.getChildren().remove(root.getChildren().size()-1);
                root.getChildren().add(imageView);
            }
        });

        Button b11 = new Button("Rogue");
        Button b12 = new Button("Knight");
        Button b13 = new Button("Mage");
        Button b14 = new Button("Healer");
        Button b15 = new Button("Monk");


        root.getChildren().addAll(b11, b12, b13, b14, b15, new Label(""));

        Label l = new Label();

        b11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Job: " + "Rogue");
                root.getChildren().add(l);
            }
        });
        b12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Job: " + "Knight");
                root.getChildren().add(l);
            }
        });
        b13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Job: " + "Mage");
                root.getChildren().add(l);
            }
        });
        b14.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Job: " + "Healer");
                root.getChildren().add(l);
            }
        });
        b15.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setText("Job: " + "Monk");
                root.getChildren().add(l);
            }
        });
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        help(primaryStage);
        System.out.println("new char");
    }

    public static void timeline(ImageView imageView, int v) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(FRAME_DURATION_MILLIS[v]), event -> {
                    currentFrame = (currentFrame + 1) % FRAME_COUNT[v];
                    int x = currentFrame * FRAME_WIDTH[v];
                    imageView.setViewport(new javafx.geometry.Rectangle2D(x, 0, FRAME_WIDTH[v], FRAME_HEIGHT[v]));
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
