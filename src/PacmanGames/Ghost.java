package PacmanGames;

class Ghost {
    private int x;
    private int y;

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(Maze maze) {
        int nextX = (x + 2) % 15;
        int nextY = (y + 2) % 15;

        if (!maze.isWall(nextX, nextY)) {
            x = nextX;
            y = nextY;
        } else {
            moveRandomly(maze);
        }
    }

    private void moveRandomly(Maze maze) {
        char[] directions = {'w', 'a', 's', 'd'};
        char randomDirection;

        do {
            randomDirection = directions[(int) (Math.random() * directions.length)];
        } while (!isValidMove(maze, randomDirection));

        performMove(randomDirection);
    }

    private boolean isValidMove(Maze maze, char direction) {
        int newX = x;
        int newY = y;

        switch (direction) {
            case 'w':
                newX = (x - 2 + 15) % 15;
                break;
            case 'a':
                newY = (y - 2 + 15) % 15;
                break;
            case 's':
                newX = (x + 2) % 15;
                break;
            case 'd':
                newY = (y + 2) % 15;
                break;
        }

        return !maze.isWall(newX, newY);
    }

    private void performMove(char direction) {
        switch (direction) {
            case 'w':
                x = (x - 2 + 15) % 15;
                break;
            case 'a':
                y = (y - 2 + 15) % 15;
                break;
            case 's':
                x = (x + 2) % 15;
                break;
            case 'd':
                y = (y + 2) % 15;
                break;
        }
    }
}
