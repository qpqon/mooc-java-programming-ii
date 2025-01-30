package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Canvas canvas = new Canvas(200, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        
        drawSmiley(gc);
        
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        
        Scene view = new Scene(layout);
        
        window.setScene(view);
        window.show();
    }

    private void drawSmiley(GraphicsContext gc) {
        // Face circle  
        gc.setFill(Color.YELLOW);
        gc.fillOval(20, 20, 160, 160);
        
        // Circle border
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.strokeOval(20, 20, 160, 160);
        
        // Eyes
        gc.setFill(Color.BLACK);
        gc.fillOval(60, 70, 20, 20); // left
        gc.fillOval(120, 70, 20, 20); // right
        
        // Mouth
        gc.strokeArc(50, 60, 100, 90, 200, 140, ArcType.OPEN);
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
