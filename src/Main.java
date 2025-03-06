import Fraction.FractionInterface;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import Koth.*;
import StudentList.*;
import Text.*;
import Geometry.*;

import static QueueMethod.CreatedMethods.*;
import static StudentList.InitiateStudentList.openStudentList;
import static Fraction.InitiateFraction.createFraction;
import static Koth.CatCountInit.InitiateCountedCat;
import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean stop = false;
        out.println("Простолупов Р.Г. | ИТ-11 (ПМИ-1) | ЛАБОРАОРНАЯ РАБОТА №5 | Вариант 4\nВведите код задания в сответствии с таблицей (при вводе иного значения программа завершит работу):");
        while (!stop) {
            out.printf(
                    "\t\t\t\t,___________________________,\n" +
                            "Код задания:\t| 1 | 2 | 3 | 4 | 5 | 6 | 7 |\n" +
                            "Номер задания:\t|1.1|1.3|2.2|3.1|3.2|3.3|3.4|\n" +
                            "Ввод: ");
            switch (in.nextInt()) {
                case 1: {
                    out.println("Задание 1.1: Класс дробь.");
                    out.printf("Введите числитель и знаменатель дроби (два целых числа через пробел): ");
                    try {
                        FractionInterface fraction = createFraction(in.nextInt(), in.nextInt());
                        out.println("Строковое представление дроби: " + fraction + "\nДесятичное значение дроби: " + fraction.getValue());
                        out.printf("Введите новые числитель и знаменатель дроби (два целых числа через пробел): ");
                        fraction.setNumerator(in.nextInt());
                        fraction.setDenominator(in.nextInt());
                        out.println("Строковое представление дроби: " + fraction + "\nДесятичное значение дроби: " + fraction.getValue());
                    } catch (Exception e) {
                        out.println("Получена ошибка: " + e);
                    }
                    break;
                }
                case 2: {
                    out.println("Задание 2.1: Количество мяуканий.");
                    Meowable m = InitiateCountedCat("Миша");
                    m.meow();
                    m.meow();
                    m.meow();
                    m.meow();
                    out.println(m);
                    break;
                }
                case 3: {
                    out.println("Задание 3.1: Список. Вставить все элементы список после первого вхождения заданного значения.");
                    in.nextLine();
                    out.println("Введите исходный список целых чисел через пробел (не меньше одного элемента): ");
                    List<Integer> L = new ArrayList<>(Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toList());
                    out.println("Введите искомое значение: ");
                    int E = in.nextInt();
                    int index = L.indexOf(E);
                    if (index != -1) {
                        List<Integer> copy = new ArrayList<>(L);
                        L.addAll(index + 1, copy);
                        out.println("Обновлённый список: " + L);
                    } else {
                        out.println("В заданном списке нет ни одного вхождения указанного значения.");
                    }
                    break;
                }
                case 4: {
                    out.println("Задание 4.4: Мап. Вывести имена всех студентов, набравших не менее 30 баллов по каждому из экзаменов.");
                    StudentListInterface studentList = openStudentList("C:\\Documents\\Работы\\Университет\\Java\\Lab5\\src\\StudentList\\Exams.txt");
                    out.println("Исходный список: ");
                    for (String i : studentList.getStudentList()) {
                        out.println("\t" + i);
                    }
                    out.println("Список студентов, потерпевших неудачу: ");
                    for (String i : studentList.getStudentMap(false)) {
                        out.println("\t" + i);
                    }
                    break;
                }
                case 5: {
                    out.println("Задание 5.4: Сет. Напечатать в алфавитном порядке все глухие согласные буквы, которые входят в каждое нечетное слово текста из файла.");
                    Set<Character> letters = Set.of('п', 'ф', 'к', 'т', 'ш', 'щ', 'с', 'х', 'ц', 'ч',
                            'П', 'Ф', 'К', 'Т', 'Ш', 'Щ', 'С', 'Х', 'Ц', 'Ч');
                    Article article = new Article("C:\\Documents\\Работы\\Университет\\Java\\Lab5\\src\\Text\\Text.txt");

                    out.println("Исходный текст:\n" + article);
                    out.println("Извлечение указанных букв в алфавитном порядке:\n" + article.searchLetters(letters));
                    break;
                }
                case 6: {
                    out.println("Задание 6.4: Очередь. Проверить равенство участка очереди с i-го по j-й элемент (i < j).");
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(1);
                    queue.add(2);
                    queue.add(2);
                    queue.add(5);
                    queue.add(5);
                    queue.add(5);
                    out.println("Создана очередь (1,2,2,5,5,5).\n" +
                            "Равенство элементов с четвёртого по шестой: " + checkEquality(queue, 3, 5) +
                            "\nРавенство элементов со второго по пятый: " + checkEquality(queue, 1, 4)
                    );
                    break;
                }
                case 7: {
                    out.println("Задание 7.1: Стрим для обработки Point и Polyline");
                    List<Point> pointList = new ArrayList<>(Arrays.asList(new Point(1, 0), new Point(2, 2), new Point(3, -17), new Point(-9, 5), new Point(1, 0), new Point(0, -1) ));
                    out.println("Создан список точек: " + pointList);
                    Polyline line = new Polyline(pointList.stream()
                            .sorted(Comparator.comparingDouble(Point::getX))
                            .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                            .distinct()
                            .toList()
                    );
                    out.println("Из обработанного списка точек сформирован Polyline: " + line);
                    break;
                }
                case 8: {
                    out.println("Задание 7.2: Стрим для обработки файла.");
                    String path = "C:\\Documents\\Работы\\Университет\\Java\\Lab5\\src\\Text\\File1.txt";
                    out.println("Исходный файл:");
                    for (String i : Files.lines(Paths.get(path)).toList()) { out.println("\t" + i); }
                    Map<Integer, List<String>> groupedPeople = Files.lines(Paths.get(path))
                            .map(String::trim)
                            .filter(line -> line.contains(":"))
                            .map(line -> line.split(":"))
                            .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                            .collect(Collectors.groupingBy(
                                    parts -> Integer.parseInt(parts[1]),
                                    Collectors.mapping(
                                            parts -> parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase(),
                                            Collectors.toList()
                                    )
                            ));
                    System.out.println("Результат применения стрима: " + groupedPeople);
                    break;
                }
                default:
                    stop = true;
            }
        }
    }
}