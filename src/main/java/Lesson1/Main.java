package Lesson1;

public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat("Барсик", "рыжий", 1);

        System.out.println(cat);

        Turtle turtle = new Turtle("Черепаха", "коричневая", 100);
        System.out.println(turtle);

        cat.setAge(-1);
        System.out.println(cat);

        Cat cat2 = new Cat("KAY", "BLACK", 2);
        Cat cat3 = new Cat("KAY", "BLACK", 2);

        System.out.println(cat2.equals(cat3));

        cat.voice();
        turtle.voice();

        Wolf wolf = new Wolf("Trevor", "grey", 5);
        wolf.voice();

    }
}
