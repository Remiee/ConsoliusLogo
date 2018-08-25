package consoliuslogo;

import consoliuslogo.enums.Direction;
import consoliuslogo.enums.Rotate;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
    private String[] instructions;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public Rotate getRotate() {
        System.out.println("Add meg, hogy szeretnél-e fordulni. R(jobbra), L(balra)?");
        char input = scanner.next().charAt(0);
        while (input != 'R' && input != 'L') {
            System.out.println("A megadott érték nem megfelelő.");
            input = scanner.next().charAt(0);
        }

        return input == 'R' ? Rotate.RIGHT : Rotate.LEFT;
    }

    public int getDegree() {
        System.out.println("Add meg, hogy hány fokot szeretnél fordulni.");
        int rotateBy = scanner.nextInt();
        while (rotateBy % 90 != 0) {
            System.out.println("A megadott érték nem megfelelő.");
            rotateBy = scanner.nextInt();
        }

        return rotateBy;
    }

    public boolean getIsDrawing() {
        System.out.println("Akarod-e, hogy rajzoljon a teknős? Y(igen) N(nem)");
        char input = scanner.next().charAt(0);
        while (input != 'Y' && input != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            input = scanner.next().charAt(0);
        }
        return input == 'Y' ? true : false;
    }

    public Direction getDirection() {
        System.out.println("Add meg, hogy F(előre) vagy B(hátra) szeretnél menni.");
        char input = scanner.next().charAt(0);
        while (input != 'F' && input != 'B') {
            System.out.println("A megadott érték nem megfelelő.");
            input = scanner.next().charAt(0);
        }

        return input == 'F' ? Direction.FORWARD : Direction.BACKWARD;
    }

    public int getDistance() {
        System.out.println("Add meg, hogy mennyit szeretnél menni.");
        int distance = scanner.nextInt();
        while (distance < 0) {
            System.out.println("A megadott érték nem megfelelő.");
            distance = scanner.nextInt();
        }
        return distance;
    }

    public void exit() {
        System.out.println("Ki szeretnél lépni a játékból? Y(igen) N(nem)");
        char exit = scanner.next().charAt(0);
        while (exit != 'Y' && exit != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            exit = scanner.next().charAt(0);
        }
        if (exit == 'Y') {
            System.exit(0);
        }
    }

    public void getInformation() {
        System.out.println("Szia! Várom az utasításaidat!");
        String instruction = scanner.nextLine();
        instructions = instruction.split(" ");
    }
}
