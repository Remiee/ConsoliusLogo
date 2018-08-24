package consoliuslogo;

import consoliuslogo.enums.Direction;

public class Table {
    private final int height;
    private final int width;
    public char[][] map;
    private char originalValue;


    public Table(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new char[height][width];
        this.originalValue = '.';
        initializeTable();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void paintLine(int distance, boolean isDrawing, int stepX, int stepY, int x, int y) {

        for (int i = 0; i < distance; ++i) {
            if (x >= 0 && x < width && y >= 0 && y < height) {
                if (isDrawing) {
                    map[y][x] = 'x';
                } else if (i == 0 && originalValue == 'x') {
                    map[y][x] = 'x';
                } else if (i == 0) {
                    map[y][x] = '.';
                }
            }
            x += stepX;
            y += stepY;

        }
        if (x >= 0 && x < width && y >= 0 && y < height) {
            originalValue = map[y][x];
        }
    }

    public void paintTurtle(Turtle turtle) {
        if (turtle.getX() >= 0 && turtle.getX() < width && turtle.getY() >= 0 && turtle.getY() < height) {
            map[turtle.getY()][turtle.getX()] = turtle.getOrientation().getIcon();
        }
    }

    public void printTable() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void initializeTable() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = '.';
            }
        }
    }
}
