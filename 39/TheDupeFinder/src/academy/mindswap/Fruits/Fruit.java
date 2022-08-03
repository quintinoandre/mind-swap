package academy.mindswap.Fruits;

import java.util.Objects;

public abstract class Fruit implements Comparable<Fruit> {
    private int acidity;

    Fruit(int acidity) {
        this.acidity = acidity;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "acidity=" + acidity + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return acidity == fruit.acidity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acidity);
    }

    @Override
    public int compareTo(Fruit fruit) {
        return acidity > fruit.acidity ? -1 : 1;
    }
}
