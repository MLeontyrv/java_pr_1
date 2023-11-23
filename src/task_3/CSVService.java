package task_3;
import java.util.List;

public interface CSVService {

    void import(String filename);
    void export(List<Division> divisions);
}

