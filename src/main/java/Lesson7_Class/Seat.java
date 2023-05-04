package Lesson7_Class;

public class Seat extends CarElement {
    private Integer seatsCount;

    public Seat() {
    }

    public Seat(Integer seatsCount) {
        this.seatsCount = seatsCount;
        setName("Сидение");
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatsCount=" + seatsCount +
                '}';
    }

    public Integer getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(Integer seatsCount) {
        this.seatsCount = seatsCount;
    }
}
