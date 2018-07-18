package consoliuslogo;

import java.util.Scanner;

public class InputHandler {
    private char rotate;
    private int degree;
    private boolean isDrawing;
    private char direction;
    private int distance;

    public char getRotate() {
        return rotate;
    }
    public int getDegree() {
        return degree;
    }
    public boolean getIsDrawing() {
        return isDrawing;
    }
    public char getDirection() {
        return direction;
    }
    public int getDistance() {
        return distance;
    }


    public void getInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ki szeretnél lépni a játékból? Y(igen) N(nem)");
        char exit = scanner.next().charAt(0);
        if (exit != 'Y' && exit != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            exit = scanner.next().charAt(0);
        }
        if (exit == 'Y') {
            System.exit(0);
        }

        System.out.println("Add meg, hogy szeretnél-e fordulni. R(jobbra), L(balra), N(nem)?");
        rotate = scanner.next().charAt(0);
        if (rotate != 'R' && rotate != 'L' && rotate != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            rotate = scanner.next().charAt(0);
        }
        if (rotate != 'N') {
            System.out.println("Add meg, hogy hány fokot szeretnél fordulni.");
            degree = scanner.nextInt();
            if (degree % 90 != 0) {
                System.out.println("A megadott érték nem megfelelő.");
                degree = scanner.nextInt();
            }
        }

        System.out.println("Akarod-e, hogy rajzoljon a teknős? Y(igen) N(nem)");
        char draw = scanner.next().charAt(0);
        if (draw != 'Y' && draw != 'N') {
            System.out.println("A megadott érték nem megfelelő.");
            draw = scanner.next().charAt(0);
        }
        isDrawing = (draw== 'Y') ? true : false;

        System.out.println("Add meg, hogy F(előre) vagy B(hátra) szeretnél menni.");
        direction = scanner.next().charAt(0);
        if (direction != 'F' && direction != 'B') {
            System.out.println("A megadott érték nem megfelelő.");
            direction = scanner.next().charAt(0);
        }

        System.out.println("Add meg, hogy mennyit szeretnél menni.");
        distance = scanner.nextInt();
        if (distance < 0) {
            System.out.println("A megadott érték nem megfelelő.");
            distance = scanner.nextInt();
        }
    }
}
