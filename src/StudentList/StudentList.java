package StudentList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StudentList implements StudentListInterface {
    List<List<String>> studentList;
    Map<Boolean, List<String>> studentMap;

    public StudentList(String path) throws IOException {
        studentList = Files
                .readAllLines(Paths.get(path))
                .stream()
                .skip(1)
                .map(s -> Arrays.stream(s.split(" ")).toList())
                .toList();
        studentMap = new HashMap<>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
        for (List<String> i : studentList) {
            studentMap.get(Integer.parseInt(i.get(2)) >= 30 && Integer.parseInt(i.get(3)) >= 30).add(i.get(0) + " " + i.get(1));
        }
    }

    public List<String> getStudentList() {
        return studentList.stream().map(i -> String.join(" ",i)).toList();
    }

    public List<String> getStudentMap(Boolean b) throws IOException {
        return studentMap.get(b);
    }
}
