package br.com.stdplayer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    Player audioPlayer;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);
        GridPane centerGrid = new GridPane();
    
        audioPlayer = new Player();
        audioPlayer.addTo(centerGrid);
        audioPlayer.arrangeElements();
        
        root.setCenter(centerGrid);

        primaryStage.setTitle("stdplayer");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    @Override
    public void stop() throws Exception {
        // TODO Auto-generated method stub
        super.stop();
        audioPlayer.dispose();
        
    }
    
    
    
}
