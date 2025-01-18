package ticTacToe;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

// This program does a little bit more than what was asked because I wanted the "winning buttons"
// to be highlighted. 

public class TicTacToeApplication extends Application {    
    TicTacToeGame game;
    private int gridSize;
    
    public void init() {
        this.game = new TicTacToeGame();
        this.gridSize = 3;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        // Feedback Label
        Label referee = new Label("Turn: " + game.getPlayer());
        referee.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        
        // Tic tac toe Grid
        GridPane tttGrid = new GridPane();
        
        // Adding buttons to grid
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int row = i;
                int col = j;
                Button button = formattedButton();
                
                button.setOnMouseClicked((event) -> {
                    if (game.makeMove(row, col)) {
                        button.setText(game.getPlayer());
                        
                        if (weHaveAWInner(tttGrid)) {
                            referee.setText("Player " + game.getPlayer() + " wins!");                            
                        } else if (game.isDraw()) {
                            referee.setText("Stalemate");
                        } else {
                            game.switchPlayer();
                            referee.setText("Turn: " + game.getPlayer());
                        }
                    }
                });

                tttGrid.add(button, col, row);
            } 
        }
        
        // Layout
        BorderPane layout = new BorderPane();
        layout.setTop(referee);
        layout.setCenter(tttGrid);
        
        // Start
        Scene ticTacToe = new Scene(layout);
        
        window.setScene(ticTacToe);
        window.setTitle("Tic Tac Toe");
        window.show();
    }
    
    private Button formattedButton() {
        Button button = new Button("");
        button.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        button.setPrefSize(100, 100);
        
        return button;
    }    
        
    private boolean weHaveAWInner(GridPane grid) {
        int[] goldenNumbers = game.winningStreak();
        
        if (goldenNumbers != null) {
            disableAllButtons(grid);
            highlightWinButtons(grid, goldenNumbers);                      
            return true;
        }
        return false;
    }
    
    private void disableAllButtons(GridPane grid) {
        for (Node node : grid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setDisable(true);
            }
        }
    }
    
    private void highlightWinButtons(GridPane grid, int[] coordinates) {
        for (int k = 0; k < coordinates.length; k += 2) {
            int row = coordinates[k];
            int col = coordinates[k + 1];

            for (Node node : grid.getChildren()) {
                if (node instanceof Button) {
                    Button button = (Button) node;

                    Integer gridRow = grid.getRowIndex(button);
                    Integer gridCol = grid.getColumnIndex(button);

                    if (gridRow == row && gridCol == col) {
                        button.setDisable(false);
                    }
                }
            }    
        }
    }
}
