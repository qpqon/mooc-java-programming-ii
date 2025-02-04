
public class Program {

    public static void main(String[] args) {
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));     
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder arrayElements = new StringBuilder();
        
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                int arrayValue = array[row][col];
                arrayElements.append(arrayValue);
            }
            arrayElements.append("\n");
        }
        return arrayElements.toString();
    }
}
