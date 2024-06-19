package PacmanGames;

class Pacman {
    private int x;
    private int y;

    public Pacman(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(char direction) {
        switch (direction) {
            case 'w':
                x--;
                break;
            case 'a':
                y--;
                break;
            case 's':
                x++;
                break;
            case 'd':
                y++;
                break;
        }
    }
}
