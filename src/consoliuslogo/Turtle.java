package consoliuslogo;

public class Turtle {
    private static final char TURTLE_UP = '\u25B2';
    private static final char TURTLE_DOWN = '\u25BC';
    private static final char TURTLE_RIGHT = '\u25B6';
    private static final char TURTLE_LEFT = '\u25C0';

    private int y;
    private int x;
    private int orientation;
    private InputHandler inputHandler;
    private Table table;
    private char originalValue;


    public Turtle(int y, int x, InputHandler inputHandler, Table table) {
        this.y = y - 1;
        this.x = x - 1;
        this.orientation = 90;
        this.inputHandler = inputHandler;
        this.table = table;
        table.map[y - 1][x - 1] = TURTLE_RIGHT;
    }

    public void moveTurtle(char direction) {
        calculateOrientation(inputHandler.getRotate(), inputHandler.getDegree());

        if ((direction == 'F' && orientation == 90) || (direction == 'B' && orientation == 270)) {
            increaseX(x);
        } else if ((direction == 'F' && orientation == 180) || (direction == 'B' && orientation == 0)) {
            increaseY(y);
        } else if ((direction == 'B' && orientation == 90) || (direction == 'F' && orientation == 270)) {
            decreaseX(x);
        } else if ((direction == 'B' && orientation == 180) || (direction == 'F' && orientation == 0)) {
            decreaseY(y);
        }
    }

    private void calculateOrientation(char rotate, int degree) {
        if (rotate == 'R') {
            orientation += degree;
        } else if (rotate == 'L') {
            orientation -= degree;
        }

        if (orientation % 360 < 0) {
            orientation = 360 - Math.abs(orientation % 360);
        } else {
            orientation = orientation % 360;
        }
    }

    private int calculateEndPosition(int coordinate, int size, int distance) {
        int endPosition = coordinate + distance;
        if (endPosition >= size) {
            endPosition = size - 1;
        }
        if (endPosition < 0) {
            endPosition = 0;
        }
        return endPosition;
    }

    private void increaseX(int coordinate) {
        int endPosition = calculateEndPosition(x, table.getWidth(), inputHandler.getDistance());

        for (int i = coordinate; i < endPosition; ++i) {
            if (inputHandler.getIsDrawing()) {
                table.map[y][i] = 'x';
            } else if (i == coordinate && originalValue == 'x') {
                table.map[y][i] = 'x';
            } else if (i == coordinate) {
                table.map[y][i] = '.';
            }
        }
        x = endPosition;
        originalValue = table.map[y][endPosition];
        table.map[y][endPosition] = (orientation == 90) ? TURTLE_RIGHT : TURTLE_LEFT;
    }

    private void increaseY(int coordinate) {
        int endPosition = calculateEndPosition(y, table.getHeight(), inputHandler.getDistance());

        for (int i = coordinate; i < endPosition; ++i) {
            if (inputHandler.getIsDrawing()) {
                table.map[i][x] = 'x';
            } else if (i == coordinate && originalValue == 'x') {
                table.map[i][x] = 'x';
            } else if (i == coordinate) {
                table.map[i][x] = '.';
            }
        }
        y = endPosition;
        originalValue = table.map[endPosition][x];
        table.map[endPosition][x] = (orientation == 180) ? TURTLE_DOWN : TURTLE_UP;
    }

    private void decreaseX(int coordinate) {
        int endPosition = calculateEndPosition(x, table.getWidth(), -inputHandler.getDistance());

        for (int i = coordinate; i > endPosition; --i) {
            if (inputHandler.getIsDrawing()) {
                table.map[y][i] = 'x';
            } else if (i == coordinate && originalValue == 'x') {
                table.map[y][i] = 'x';
            } else if (i == coordinate) {
                table.map[y][i] = '.';
            }
        }
        x = endPosition;
        originalValue = table.map[y][endPosition];
        table.map[y][endPosition] = (orientation == 90) ? TURTLE_RIGHT : TURTLE_LEFT;
    }

    private void decreaseY(int coordinate) {
        int endPosition = calculateEndPosition(y, table.getHeight(), -inputHandler.getDistance());

        for (int i = coordinate; i > endPosition; --i) {
            if (inputHandler.getIsDrawing()) {
                table.map[i][x] = 'x';
            } else if (i == coordinate && originalValue == 'x') {
                table.map[i][x] = 'x';
            } else if (i == coordinate) {
                table.map[i][x] = '.';
            }
        }
        y = endPosition;
        originalValue = table.map[endPosition][x];
        table.map[endPosition][x] = (orientation == 180) ? TURTLE_DOWN : TURTLE_UP;
    }
}
