package academy.mindswap.gameobjects.fruit;

import academy.mindswap.field.Position;

import static academy.mindswap.field.Field.getHeight;
import static academy.mindswap.field.Field.getWidth;
import static academy.mindswap.utils.GenerateRandomPosition.generateRandomPosition;

public class Fruit {
    private Position position;

    public Fruit() {
        this.position = new Position(generateRandomPosition(1, getWidth() - 1), generateRandomPosition(1, getHeight() - 1));
    }

    public Position getPosition() {
        return this.position;
    }


}
