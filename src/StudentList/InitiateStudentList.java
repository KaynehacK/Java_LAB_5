package StudentList;

import java.io.IOException;

public class InitiateStudentList {
    public static StudentListInterface openStudentList(String path) throws IOException {
        return new StudentList(path);
    }
}
