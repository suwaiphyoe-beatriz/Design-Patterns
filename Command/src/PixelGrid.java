public class PixelGrid {

    private final int SIZE = 8;
    private int[][] grid = new int[SIZE][SIZE];

    private int cursorRow = 0;
    private int cursorCol = 0;

    public void moveUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    public void togglePixel() {
        grid[cursorRow][cursorCol] = 1 - grid[cursorRow][cursorCol];
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void generateCode() {
        System.out.println("int[][] pixelArt = {");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("    {");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]);
                if (j < SIZE - 1) System.out.print(", ");
            }
            System.out.println("}" + (i < SIZE - 1 ? "," : ""));
        }
        System.out.println("};");
    }
}