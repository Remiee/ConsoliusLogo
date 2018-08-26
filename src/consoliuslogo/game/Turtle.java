package consoliuslogo.game;

import consoliuslogo.control.Command;
import consoliuslogo.control.Orientation;

public class Turtle {
    private int y;
    private int x;
    private Orientation orientation = Orientation.EAST;

    public Turtle(int y, int x) {
        this.y = y - 1;
        this.x = x - 1;
    }

    public void executeCommand(Command command, Table table) {
        for (int i = 0; i < command.getRepeatCount(); ++i) {
            moveTurtle(command, table);
        }
    }

    private void moveTurtle(Command command, Table table) {
        orientation = calculateOrientation(command.getRotateBy());

        int stepX = orientation.getStepX();
        int stepY = orientation.getStepY();
        if (command.getDistance() < 0) {
            stepX = stepX * -1;
            stepY = stepY * -1;
        }

        table.paintLine(Math.abs(command.getDistance()), command.isDrawing(), stepX, stepY, x, y);

        x += Math.abs(command.getDistance()) * stepX;
        y += Math.abs(command.getDistance()) * stepY;
    }

    private  Orientation calculateOrientation(int rotateBy) {

        int degree = orientation.getDegree();
        degree = (degree + rotateBy) % 360;
        if (degree < 0) {
            degree += 360;
        }
        return Orientation.fromDegree(degree);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
