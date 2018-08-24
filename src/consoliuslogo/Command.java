package consoliuslogo;

import consoliuslogo.enums.Direction;
import consoliuslogo.enums.Rotate;

public class Command {
    private final Direction direction;
    private final int distance;
    private final int rotateBy;
    private final boolean isDrawing;
    private final int repeatCount;

    public Command(Rotate rotate, int rotateBy, Direction direction, int distance, boolean isDrawing, int repeatCount) {
        this.direction = direction;
        this.distance = distance;
        this.rotateBy = rotate == Rotate.RIGHT ? rotateBy : -1 * rotateBy;
        this.isDrawing = isDrawing;
        this.repeatCount = repeatCount;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    public int getRotateBy() {
        return rotateBy;
    }

    public boolean getIsDrawing() {
        return isDrawing;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
