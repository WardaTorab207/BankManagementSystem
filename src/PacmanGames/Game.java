package PacmanGames;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Maze maze = new Maze(22);
        Pacman pacman = new Pacman(9, 2);
        Ghost ghost1 = new Ghost(8, 3);
        Ghost ghost2 = new Ghost(1, 8);
        int score = 0;

        while (true) {
            maze.printMaze(pacman.getX(), pacman.getY(), ghost1.getX(), ghost1.getY(), ghost2.getX(), ghost2.getY());

            System.out.print("Enter a move (w/a/s/d): ");
            char move = sc.next().charAt(0);

            int prevX = pacman.getX();
            int prevY = pacman.getY();

            pacman.move(move);
            ghost1.move(maze);
            ghost2.move(maze);

            if (maze.isWall(pacman.getX(), pacman.getY())) {
                System.out.println("Game over! You hit a wall!");
                break;
            }

            if (pacman.getX() == ghost1.getX() && pacman.getY() == ghost1.getY()
                    || pacman.getX() == ghost2.getX() && pacman.getY() == ghost2.getY()) {
                System.out.println("Game over! You got caught by a ghost!");
                break;
            }

            if (maze.isDot(pacman.getX(), pacman.getY())) {
                score += 1;
                maze.removeDot(pacman.getX(), pacman.getY());
            }

            System.out.println("SCORE:" + score+"\n");
        }
    }
}
