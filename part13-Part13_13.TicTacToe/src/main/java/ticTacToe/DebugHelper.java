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
public class DebugHelper {
    
    public static void main(String[] args) {
        TicTacToeGame test = new TicTacToeGame();
        
        test.makeMove(0, 0);
        test.makeMove(0, 1);
        test.makeMove(0, 2);
        
        test.switchPlayer();
        test.makeMove(1, 0);
        test.makeMove(1, 1);
        
        // test.printBoard();
        
        int[] streak = test.winningStreak();
        
        for (int i = 0; i < streak.length; i++) {
            System.out.print(streak[i] + ", ");
        }
    }
}
