package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

// This task is broken by default because the dependency javafx.scene.media.AudioClip;
// had not been implemented. Although I could add it to Maven and "trick" the test into
// accepting my solution, I am not able to upload it to Helsinki servers because
// it does not compile apparently. 

public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
        AudioClip applause = new AudioClip("file:Applause-Yannick_Lemieux.wav");

        Button nappi = new Button("Hurraa!");
        nappi.setOnAction((event) -> applause.play());
        
        BorderPane pane = new BorderPane();
        pane.setCenter(nappi);

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
