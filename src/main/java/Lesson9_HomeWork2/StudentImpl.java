package Lesson9_HomeWork2;

import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements Student{

    private String name;
    private List<Course> courses;

    @Override
    public String toString() {
        return "StudentImpl{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

    public StudentImpl(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses == null ? new ArrayList<>(0) : courses;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }
}
