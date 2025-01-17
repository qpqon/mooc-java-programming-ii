package ticTacToe;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class TicTacToeGame {
    private String[][] board;
    private String player;
    private int round;
    
    public TicTacToeGame() {
        this.board  = new String[3][3];
        this.player = "X";
        this.round  = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = "";
            }
        }
    }
    
    public boolean makeMove(int row, int col) {
        if (this.board[row][col].equals("")) {
            this.board[row][col] = this.player;
            this.round++;
            return true;
        }
        return false;
    }
    
    public int[] winningStreak() {
        if (this.round >= 4) { // first possibility of win
            int[][] winConditions = {
                {0,0,1,0,2,0}, // row 1
                {0,1,1,1,2,1}, // row 2
                {0,2,1,2,2,2}, // row 3
                {0,0,0,1,0,2}, // col 1
                {1,0,1,1,1,2}, // col 2
                {2,0,2,1,2,2}, // col 3
                {0,0,1,1,2,2}, // diagonal 1
                {0,2,1,1,2,0}  // diagonal 2
            };

            for (int[] condition : winConditions) {
                int x1 = condition[0], y1 = condition[1];
                int x2 = condition[2], y2 = condition[3];
                int x3 = condition[4], y3 = condition[5];

                if (!board[x1][y1].equals("") &&
                    board[x1][y1].equals(board[x2][y2]) &&
                    board[x1][y1].equals(board[x3][y3])) {

                    int[] winningStreak = {x1,y1,x2,y2,x3,y3};
                    return winningStreak;
                }
            }
        }
        return null;
    }
    
    public boolean isDraw() {
        return this.round == 9;
    }
    
    public String getPlayer() {
        return this.player;
    }
    
    public void switchPlayer() {
        this.player = this.player.equals("X") ? "O" : "X";
    }
    
    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + "");
            }
            System.out.println();
        }
    }
}
