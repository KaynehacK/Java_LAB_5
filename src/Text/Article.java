package Text;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Article {
    private String content;

    public Article(String path) throws IOException {
        content = Files.readString(Paths.get(path));
    }

    public String searchLetters(Set<Character> letters) throws IOException {
        List<String> words = Arrays.asList(content.split("\\s+"));
        return words.stream()
                .filter(word -> (words.indexOf(word) % 2 == 0))
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .filter(letters::contains)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return content;
    }
}
