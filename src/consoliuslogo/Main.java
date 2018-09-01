package consoliuslogo;

import consoliuslogo.control.Command;
import consoliuslogo.control.InputHandler;
import consoliuslogo.game.Table;
import consoliuslogo.game.Turtle;

import java.util.Scanner;

public class Main {
    private static final int TABLE_SIZE = 40;
    private static final int STARTING_POSITION = TABLE_SIZE / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler(scanner);
        Table table = new Table(TABLE_SIZE, TABLE_SIZE);
        Turtle turtle = new Turtle(STARTING_POSITION, STARTING_POSITION);

        while (true) {
            table.paintTurtle(turtle);
            table.printTable();
            Command command = inputHandler.getCommand();
            if (inputHandler.shouldClearConsole()) {
                table = new Table(TABLE_SIZE, TABLE_SIZE);
                turtle = new Turtle (STARTING_POSITION, STARTING_POSITION);
            }
            turtle.executeCommand(command, table);
        }
    }
}

