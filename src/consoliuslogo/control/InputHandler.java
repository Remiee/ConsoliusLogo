package consoliuslogo.control;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public Command parseCommand() {
        System.out.println("Szia! Várom az utasításaidat!");
        String[] instructions = scanner.nextLine().split(" ");

        int rotateBy = getValue(instructions,"R", "L");
        int distance = getValue(instructions,"F", "B");
        return new Command(rotateBy, distance, isDrawing(instructions), getRepeatCount(instructions));
    }

    private int getValue(String[] instructions, String keyPositive, String keyNegative) {
        for (int i = 0; i < instructions.length; ++i) {
            if (instructions[i].equals(keyPositive) || instructions[i].equals(keyNegative)) {
                int value = Integer.parseInt(instructions[i + 1]);
                return instructions[i].equals(keyPositive) ? value : -1 * value;
            }
        }
        return 0;
    }

    private boolean isDrawing(String[] instructions) {
        for (int i = 0; i < instructions.length; ++i) {
            if (instructions[i].equals("DD")) {
                return false;
            }
        }
        return true;
    }

    private int getRepeatCount(String[] instructions) {
        for (int i = 0; i < instructions.length; ++i) {
            if (instructions[i].equals("I")) {
                return Integer.parseInt(instructions[i + 1]);
            }
        }
        return 1;
    }
}