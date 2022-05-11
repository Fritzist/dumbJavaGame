import java.awt.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        //object and Board
        Point playerPosition = new Point(10, 9);
        Point snakePosition = new Point(30, 2);
        Point goldPosition = new Point(6, 6);
        Point dorPosition = new Point(2, 5);
        boolean continueM = true;
        boolean collectG = false;

        //position form the objects
        while (continueM) {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 40; x++) {
                    Point p = new Point(x, y);
                    if (p.equals(playerPosition))
                        System.out.print("P");

                    else if (p.equals(snakePosition))
                        System.out.print("S");

                    else if (p.equals(goldPosition))
                        System.out.print("G");

                    else if (p.equals(dorPosition))
                        System.out.print("D");

                    else
                        System.out.print(".");
                }
                System.out.println();
            }
            //snake catches the player
            if (snakePosition.equals(playerPosition)) {
                continueM = false;
                System.out.println("The snake got you");
            }
            //collecting the gold
            if (playerPosition.equals(goldPosition)) {
                collectG = true;
                goldPosition = new Point(-1 ,1);
            }
            // checking win
            if (playerPosition.equals(dorPosition) && collectG) {
                continueM = false;
                System.out.println("You won");
            }

            movePlayer(playerPosition);
            moveSnake(snakePosition, playerPosition);

        }
    }

    //snake follow the player
    private static void moveSnake(Point snakePosition, Point playerPosition) {
        if (playerPosition.x < snakePosition.x)
            snakePosition.x--;
        else if (playerPosition.x > snakePosition.x) {
            snakePosition.x++;
        }
        if (playerPosition.y < snakePosition.y)
            snakePosition.y--;
        else if (playerPosition.y > snakePosition.y) {
            snakePosition.y++;
        }
    }

    //input to move the player
    private static void movePlayer (Point playerPosition){
            Scanner scan = new Scanner(System.in);
            String input = scan.next();

            if (input.equals("w")) {
                if (playerPosition.y > 0)
                    playerPosition.y--;
            } else if (input.equals("s")) {
                if (playerPosition.y < 9)
                    playerPosition.y++;
            } else if (input.equals("a")) {
                if (playerPosition.x > 0)
                    playerPosition.x--;
            } else if (input.equals("d")) {
                if (playerPosition.x < 39)
                    playerPosition.x++;

        }
    }
}
