package consoliuslogo;

import consoliuslogo.enums.Direction;
import consoliuslogo.enums.Rotate;

import java.util.Scanner;

public class InputHandler {
    private Rotate rotate;
    private int rotateBy;
    private boolean isDrawing;
    private Direction direction;
    private int distance;
    private String[] instructions;

    public Rotate getRotate(Scanner scanner) {
        System.out.println("Add meg, hogy szeretnél-e fordulni. R(jobbra), L(balra)?");
        rotate = null;
        char input = scanner.next().charAt(0);
        while (input != 'R' && input != 'L') {
            System.out.println("A megadott érték nem megfelelő.");
            input = scanner.next().charAt(0);
        }
        rotate = input == 'R' ? Rotate.RIGHT : Rotate.LEFT;

        return rotate;
    }

    public int getDegree(Scanner scanner) {
        System.out.println("Add meg, hogy hány fokot szeretnél fordulni.");
        rotateBy = scanner.nextInt();
        while (rotateBy % 90 != 0) {
            System.out.println("A megadott érték nem megfelelő.");
            rotateBy = scanner.nextInt();
        }

        return rotateBy;
    }

    public boolean getIsDrawing(Scanner scanner) {
        System.out.println("Akarod-e, hogy rajzoljon a teknős? Y(igen) N(nem)");
        char draw = scanner.next().charAt(0);
        while (draw != 'Y' && draw != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            draw = scanner.next().charAt(0);
        }
        isDrawing = draw == 'Y' ? true : false;
        return isDrawing;
    }

    public Direction getDirection(Scanner scanner) {
        System.out.println("Add meg, hogy F(előre) vagy B(hátra) szeretnél menni.");
        char input = scanner.next().charAt(0);
        while (input != 'F' && input != 'B') {
            System.out.println("A megadott érték nem megfelelő.");
            input = scanner.next().charAt(0);
        }
        direction = input == 'F' ? Direction.FORWARD : Direction.BACKWARD;

        return direction;
    }

    public int getDistance(Scanner scanner) {
        System.out.println("Add meg, hogy mennyit szeretnél menni.");
        distance = scanner.nextInt();
        while (distance < 0) {
            System.out.println("A megadott érték nem megfelelő.");
            distance = scanner.nextInt();
        }
        return distance;
    }

    public void exit(Scanner scanner) {
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
}
