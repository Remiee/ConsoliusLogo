package consoliuslogo;

public class Table {
    private final int height;
    private final int width;
    public char[][] map;

    public Table(int height, int width) {
        this.height = height;
        this.width = width;
        this.map = new char[height][width];
        initializeTable();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
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
