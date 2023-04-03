package Lesson1;

import java.util.Objects;

public class Cat extends Animal{


    public Cat(String name, String color, int age) {
        super(name, color, age);

    }

    public void voice() {
        System.out.println("кот мяукает");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return getAge() == cat.getAge() && Objects.equals(getName(), cat.getName()) && Objects.equals(getColor(), cat.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getColor(), getAge());
    }

    public String toString() {
        return "Cat " +
                "name = " + getName() +
                " color = " + getColor() +
                " age =" + getAge();
    }


}
