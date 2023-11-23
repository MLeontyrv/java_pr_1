package task_3;
import java.util.List;

public abstract class Division {
    private String name;
    public Division(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public abstract void addEmployer(Employer employer);
    public abstract List<Employer> getEmployerList();
}