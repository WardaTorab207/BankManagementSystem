package PacmanGames;


class Maze {
    private String arr[][];
    private int size;

    public Maze(int size) {
        this.size = size;
        this.arr = new String[size][size];
        initializeMaze();
    }

    private void initializeMaze() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                arr[x][y] = ".";
            }
        }
        for (int x = 0; x < size; x++) {
            arr[x][0] = "#";
            arr[x][size - 1] = "#";
        }
        for (int y = 0; y < size; y++) {
            arr[0][y] = "#";
            arr[size - 1][y] = "#";
        }
        arr[12][11] = "#";
        arr[5][10] = "#";
        arr[5][6] = "#";
        arr[5][7] = "#";
        arr[5][8] = "#";
        arr[5][9] = "#";
        arr[8][10] = "#";
        arr[8][6] = "#";
        arr[8][7] = "#";
        arr[8][8] = "#";
        arr[8][9] = "#";
        arr[8][11] = "#";
        arr[9][14] = "#";
        arr[4][14] = "#";
        arr[9][3] = "#";
        arr[4][3] = "#";
        arr[8][9] = "#";
        arr[5][3] = "#";
        arr[6][3] = "#";
        arr[7][3] = "#";
        arr[8][3] = "#";
        arr[5][14] = "#";
        arr[6][14] = "#";
        arr[7][14] = "#";
        arr[8][14] = "#";
        arr[12][13] = "#";
        arr[12][12] = "#";
        arr[12][10] = "#";
        arr[12][11] = "#";
        arr[12][9] = "#";
        arr[12][8] = "#";
        arr[12][7] = "#";
        arr[12][6] = "#";
        arr[12][5] = "#";
        arr[12][4] = "#";
        arr[12][3] = "#";
        arr[14][3] = "#";
        arr[14][4] = "#";
        arr[14][5] = "#";
        arr[14][6] = "#";
        arr[14][7] = "#";
        arr[14][8] = "#";
        arr[14][9] = "#";
        arr[14][10] = "#";
        arr[14][11] = "#";
        arr[14][12] = "#";
        arr[14][13] = "#";
    }

    public void printMaze(int pacmanX, int pacmanY, int ghost1X, int ghost1Y, int ghost2X, int ghost2Y) {
        arr[pacmanX][pacmanY] = "P";
        arr[ghost1X][ghost1Y] = "G";
        arr[ghost2X][ghost2Y] = "G";

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print(arr[x][y] + " ");
            }
            System.out.println();
        }

        arr[pacmanX][pacmanY] = " ";
        arr[ghost1X][ghost1Y] = ".";
        arr[ghost2X][ghost2Y] = ".";
    }
    public boolean isWall(int x, int y) {
        return arr[x][y].equals("#");
    }
    public boolean isDot(int x, int y) {
        return arr[x][y].equals(".");
    }
    public void removeDot(int x, int y) {
        arr[x][y] = " ";
    }
}