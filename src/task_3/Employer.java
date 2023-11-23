package task_3;

public class Employer {
    private String name;
    private int salary;
    private PositionType position;
    private Division division;
    public Employer(String name, int salary, PositionType position, Division division) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.division = division;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public PositionType getPosition() {
        return position;
    }
    public Division getDivision() {
        return division;
    }
}