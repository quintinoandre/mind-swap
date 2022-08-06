package academy.mindswap.gameobjects.snake;

import academy.mindswap.field.Position;

import java.util.LinkedList;
import java.util.List;

import static academy.mindswap.field.Field.getHeight;
import static academy.mindswap.field.Field.getWidth;
import static academy.mindswap.gameobjects.snake.Direction.*;

public class Snake {
    private static final int SNAKE_INITIAL_SIZE = 3;
    private Direction direction;
    private boolean alive;

    private List<Position> snake;

    public Snake() {
        snake = new LinkedList<>();

        alive = true;

        generateInitialPositions(snake);

        this.direction = RIGHT;
    }

    private void generateInitialPositions(List<Position> snake) {
        for (int i = SNAKE_INITIAL_SIZE; i > 0; i--) {
            snake.add(new Position(i + ((getWidth() / 2) - Math.abs(SNAKE_INITIAL_SIZE / 2)), getHeight() / 2));
        }
    }

    public void increaseSize() {
        switch (this.direction) {
            case RIGHT -> {
                if (getHeadX() == getWidth() - 2) {
                    snake.add(new Position(geTailX() - 1, getTailY()));

                    return;
                }

                snake.add(0, new Position(getHeadX() + 1, getHeadY()));
            }
            case LEFT -> {
                if (getHeadX() == 1) {
                    snake.add(new Position(geTailX() + 1, getTailY()));

                    return;
                }

                snake.add(0, new Position(getHeadX() - 1, getHeadY()));
            }
            case UP -> {
                if (getHeadY() == 1) {
                    snake.add(new Position(geTailX(), getTailY() + 1));

                    return;
                }

                snake.add(0, new Position(getHeadX(), getHeadY() - 1));
            }
            case DOWN -> {
                if (getHeadY() == getHeight() - 2) {
                    snake.add(new Position(geTailX(), getTailY() - 1));

                    return;
                }

                snake.add(0, new Position(getHeadX(), getHeadY() + 1));
            }
        }
    }

    public int getHeadX() {
        return getHead().getCol();
    }

    public int getHeadY() {
        return getHead().getRow();
    }

    public int geTailX() {
        return getTail().getCol();
    }

    public int getTailY() {
        return getTail().getRow();
    }

    public void move(Direction direction) {
        if (this.direction == RIGHT && direction != LEFT || this.direction == LEFT && direction != RIGHT
                || this.direction == UP && direction != DOWN || this.direction == DOWN && direction != UP) {
            this.direction = direction;
        }

        switch (this.direction) {
            case RIGHT -> {
                snake.add(0, new Position(getHeadX() + 1, getHeadY()));

                snake.remove(snake.size() - 1);
            }
            case LEFT -> {
                snake.add(0, new Position(getHeadX() - 1, getHeadY()));

                snake.remove(snake.size() - 1);
            }
            case UP -> {
                snake.add(0, new Position(getHeadX(), getHeadY() - 1));

                snake.remove(snake.size() - 1);
            }
            case DOWN -> {
                snake.add(0, new Position(getHeadX(), getHeadY() + 1));

                snake.remove(snake.size() - 1);
            }
        }
    }

    public void move() {
        move(direction);
    }

    public void die() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public Position getHead() {
        return snake.get(0);
    }

    public Position getTail() {
        return snake.get(snake.size() - 1);
    }

    public List<Position> getFullSnake() {
        return snake;
    }

    public int getSnakeSize() {
        return snake.size();
    }
}

