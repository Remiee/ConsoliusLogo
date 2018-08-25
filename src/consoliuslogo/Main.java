package consoliuslogo;

import consoliuslogo.control.Command;
import consoliuslogo.control.InputHandler;
import consoliuslogo.game.Table;
import consoliuslogo.game.Turtle;

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
            Command command = inputHandler.parseCommand();
            turtle.executeCommand(command, table);
        }
    }
}

