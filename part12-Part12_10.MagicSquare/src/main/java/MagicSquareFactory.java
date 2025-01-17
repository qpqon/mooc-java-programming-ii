
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        
        MagicSquare square = new MagicSquare(size);        
        int spaces = size * size;        
        
        int row = 0;
        int col = size / 2;
        int num = 1;        

        for (int i = 0; i < spaces; i++) {
            square.placeValue(col, row, num);
            
            int testRow = (row - 1 + size) % size;
            int testCol = (col + 1) % size;
            num++;
            
            if (square.readValue(testCol, testRow) != 0) {
                row = (row + 1) % size;
            } else {
                row = testRow;
                col = testCol;
            }
        }       
        return square;
    }

}
