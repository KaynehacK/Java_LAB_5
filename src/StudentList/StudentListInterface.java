package StudentList;

import java.io.IOException;
import java.util.List;

public interface StudentListInterface {
    List<String> getStudentList();
    List<String> getStudentMap(Boolean b) throws IOException;
}
