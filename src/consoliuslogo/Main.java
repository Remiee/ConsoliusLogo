package consoliuslogo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Table table = new Table(20, 20);
        Turtle turtle = new Turtle(10, 10);

        while (true) {
            table.paintTurtle(turtle);
            table.printTable();
            inputHandler.exit();
            Command command = new Command(inputHandler.getRotate(),
                                          inputHandler.getDegree(),
                                          inputHandler.getDirection(),
                                          inputHandler.getDistance(),
                                          inputHandler.getIsDrawing(),
                                         1);
            turtle.executeCommand(command, table);
        }
    }
}

