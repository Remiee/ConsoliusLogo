package consoliuslogo;

public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Table table = new Table(20, 20);
        Turtle turtle = new Turtle(10, 10, inputHandler, table);

        while (true) {
            table.printTable();
            inputHandler.getInformation();
            turtle.moveTurtle(inputHandler.getDirection());
        }
    }
}

