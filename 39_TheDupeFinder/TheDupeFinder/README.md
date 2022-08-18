```java
public static void main(String[]args){


        Apple apple=new Apple(1);


        List<Fruit> fruits=Arrays.asList(
        apple,
        new Apple(0),

        new Orange(3),
        new Orange(2),
        new Orange(2),//DUPE
        new Apple(2),
        apple, // DUPE
        new Orange(3), // DUPE
        new Orange(3), // DUPE
        new Orange(4)
        );

        DupeFinder<Fruit> dupeFinder=new DupeFinder<>(fruits);
        System.out.println(dupeFinder.checkDupes()); //prints the number of dupes

        for(Fruit fruit:dupeFinder.getDupes()){  //only prints dupes
        System.out.println(fruit);
        }

        for(Fruit fruit:dupeFinder.sortedDupes()){ //print dupes ordered by acidity from biggest to the smallest
        System.out.println(fruit);
        }
        }
```