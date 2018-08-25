package consoliuslogo.control;

public enum Orientation {
    NORTH(0, '▲', 0, -1),
    WEST(270, '⯇', -1, 0),
    SOUTH(180, '▼', 0, 1),
    EAST(90, '▶', 1, 0);

    private int degree;
    private char icon;
    private final int stepX;
    private final int stepY;

    Orientation(int degree, char icon, int stepX, int stepY) {
        this.degree = degree;
        this.icon = icon;
        this.stepX = stepX;
        this.stepY = stepY;
    }

    public int getDegree() {
        return degree;
    }

    public char getIcon() {
        return icon;
    }

    public int getStepX() {
        return stepX;
    }

    public int getStepY() {
        return stepY;
    }

    public static Orientation fromDegree(int degree) {
        switch (degree) {
            case 270:
                return Orientation.WEST;
            case 180:
                return Orientation.SOUTH;
            case 90:
                return Orientation.EAST ;
            default:
                return Orientation.NORTH;
        }
    }
}
