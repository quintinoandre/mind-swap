package academy.mindswap.field;

import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;

import static academy.mindswap.Game.getLastRecord;
import static academy.mindswap.Game.getScore;
import static com.googlecode.lanterna.screen.ScreenCharacterStyle.Blinking;

public final class Field {

    private static final String BORDER_STRING = "▒";
    private static final String SNAKE_BODY_STRING = "█";
    private static final String SNAKE_HEAD_STRING = "█";
    private static final String FRUIT_STRING = "█";

    private static final String GAME_NAME = " SNAKE GAME ";
    private static final String GAME_OVER_PHRASE = "GAME OVER";
    private static final String SCORE_PHRASE = " SCORE: ";
    private static final String RECORD_PHRASE = " RECORD: ";

    private static int width;
    private static int height;
    private static Screen screen;
    private static ScreenWriter screenWriter;

    private Field() {
    }

    public static void init(int width, int height) {
        screen = TerminalFacade.createScreen();

        Field.width = width;

        Field.height = height;

        screen.getTerminal().getTerminalSize().setColumns(width);

        screen.getTerminal().getTerminalSize().setRows(height);

        screenWriter = new ScreenWriter(screen);

        screen.setCursorPosition(null);

        screen.startScreen();

        drawWalls();

        screen.refresh();
    }

    public static void drawSnake(Snake snake) {
        drawWalls();

        Terminal.Color snakeColor = Terminal.Color.GREEN;

        Terminal.Color snakeHeadColor = Terminal.Color.BLUE;

        if (!snake.isAlive()) {
            snakeColor = Terminal.Color.RED;

            snakeHeadColor = Terminal.Color.MAGENTA;

            screenWriter.drawString((getWidth() / 2) - Math.abs(GAME_OVER_PHRASE.length() / 2), getHeight() / 2,
                    GAME_OVER_PHRASE, Blinking);
        }

        Position head = snake.getHead();

        for (Position p : snake.getFullSnake()) {
            if (!p.equals(head)) {
                screen.putString(p.getCol(), p.getRow(), SNAKE_BODY_STRING, snakeColor, null);
            } else {
                screen.putString(p.getCol(), p.getRow(), SNAKE_HEAD_STRING, snakeHeadColor, null);
            }
        }

        screen.refresh();
    }

    public static void clearTail(Snake snake) {
        Position tail = snake.getTail();

        screen.putString(tail.getCol(), tail.getRow(), " ", null, null);
    }

    private static void drawWalls() {
        for (int i = 0; i < width; i++) {
            screenWriter.drawString(i, 0, BORDER_STRING);

            screenWriter.drawString(i, height - 1, BORDER_STRING);
        }

        for (int j = 0; j < height; j++) {
            screenWriter.drawString(0, j, BORDER_STRING);

            screenWriter.drawString(width - 1, j, BORDER_STRING);
        }

        screenWriter.drawString(((getWidth() / 2) - Math.abs(GAME_NAME.length() / 2)), 0, GAME_NAME);

        screenWriter.drawString(1, 0, SCORE_PHRASE + getScore() + " ");

        screenWriter.drawString(width - RECORD_PHRASE.length() - (String.valueOf(getLastRecord()).length() + 2),
                0, RECORD_PHRASE + getLastRecord() + " ");
    }

    public static Key readInput() {
        return screen.readInput();
    }

    public static void drawFruit(Fruit fruit) {
        screen.putString(fruit.getPosition().getCol(), fruit.getPosition().getRow(), FRUIT_STRING, Terminal.Color.YELLOW, null);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
