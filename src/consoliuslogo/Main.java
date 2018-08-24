package consoliuslogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Table table = new Table(20, 20);
        Turtle turtle = new Turtle(10, 10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            table.paintTurtle(turtle);
            table.printTable();
            inputHandler.exit(scanner);
            Command command = new Command(
                    inputHandler.getRotate(scanner),
                    inputHandler.getDegree(scanner),
                    inputHandler.getDirection(scanner),
                    inputHandler.getDistance(scanner),
                    inputHandler.getIsDrawing(scanner),
                    1);
            turtle.executeCommand(command, table);
        }
    }
}

