package Lesson9_HomeWork2;

public class CourseImpl implements Course{
    private String name;

    @Override
    public String toString() {
        return "CourseImpl{" +
                "name='" + name + '\'' +
                '}';
    }

    public CourseImpl(String name) {
        this.name = name;
    }
}
