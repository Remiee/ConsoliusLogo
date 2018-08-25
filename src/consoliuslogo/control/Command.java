package consoliuslogo.control;

public class Command {
    private final int rotateBy;
    private final int distance;
    private final boolean isDrawing;
    private final int repeatCount;

    public Command(int rotateBy, int distance, boolean isDrawing, int repeatCount) {
        this.rotateBy = rotateBy;
        this.distance = distance;
        this.isDrawing = isDrawing;
        this.repeatCount = repeatCount;
    }

    public int getRotateBy() {
        return rotateBy;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isDrawing() {
        return isDrawing;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
