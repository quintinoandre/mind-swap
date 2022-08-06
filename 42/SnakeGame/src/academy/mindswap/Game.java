package academy.mindswap;

import academy.mindswap.field.Field;
import academy.mindswap.field.Position;
import academy.mindswap.gameobjects.fruit.Fruit;
import academy.mindswap.gameobjects.snake.Direction;
import academy.mindswap.gameobjects.snake.Snake;
import com.googlecode.lanterna.input.Key;

import java.io.IOException;

import static academy.mindswap.field.Field.*;
import static academy.mindswap.utils.ReadFromFile.readFromFile;
import static academy.mindswap.utils.WriteToFile.writeToFile;

public class Game {
    private static Snake snake;
    private static Fruit fruit;
    private static int delay;

    private static int score;
    private static int lastRecord;
    private static final String FILE_PATH = "src/academy/mindswap/records/record.csv";

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);

        snake = new Snake();

        this.delay = delay;
    }

    public static void start() throws InterruptedException {
        try {
            lastRecord = Integer.parseInt(readFromFile(FILE_PATH).trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        generateFruit();

        while (snake.isAlive()) {
            Thread.sleep(delay);

            Field.clearTail(snake);

            moveSnake();

            checkCollisions();

            Field.drawSnake(snake);
        }
    }

    private static void generateFruit() {
        fruit = new Fruit();

        for (Position position : snake.getFullSnake()
        ) {
            if (fruit.getPosition().equals(position)) {
                generateFruit();
            }
        }

        drawFruit(fruit);
    }

    private static void moveSnake() {
        Key k = Field.readInput();

        if (k != null) {
            switch (k.getKind()) {
                case ArrowUp:
                    snake.move(Direction.UP);
                    return;
                case ArrowDown:
                    snake.move(Direction.DOWN);
                    return;
                case ArrowLeft:
                    snake.move(Direction.LEFT);
                    return;
                case ArrowRight:
                    snake.move(Direction.RIGHT);
                    return;
            }
        }

        snake.move();
    }

    private static void checkCollisions() {
        if (snake.getHead().equals(fruit.getPosition())) {
            snake.increaseSize();

            delay--;

            score++;

            if (getScore() > getLastRecord()) {
                lastRecord = score;

                try {
                    writeToFile(FILE_PATH, String.valueOf(score));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            generateFruit();
        }

        for (int i = 1; i < snake.getSnakeSize(); i++) {
            if (snake.getFullSnake().get(i).equals(snake.getHead())) {
                snake.die();
            }
        }

        if (snake.getHeadX() == 0) {
            snake.getFullSnake().remove(0);

            snake.getFullSnake().add(new Position(snake.geTailX() + 1, snake.getTailY()));

            snake.die();
        }

        if (snake.getHeadX() == getWidth() - 1) {
            snake.getFullSnake().remove(0);

            snake.getFullSnake().add(new Position(snake.geTailX() - 1, snake.getTailY()));

            snake.die();
        }

        if (snake.getHeadY() == 0) {
            snake.getFullSnake().remove(0);

            snake.getFullSnake().add(new Position(snake.geTailX(), snake.getTailY() + 1));

            snake.die();
        }

        if (snake.getHeadY() == getHeight() - 1) {
            snake.getFullSnake().remove(0);

            snake.getFullSnake().add(new Position(snake.geTailX(), snake.getTailY() - 1));

            snake.die();
        }
    }

    public static int getScore() {
        return score;
    }

    public static int getLastRecord() {
        return lastRecord;
    }
}
