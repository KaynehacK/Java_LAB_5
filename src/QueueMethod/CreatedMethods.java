package QueueMethod;

import Koth.Meowable;

import java.util.Iterator;
import java.util.Queue;

public class CreatedMethods {

    public static void MeowInit(Meowable[] m) {
        for (Meowable m1 : m) {m1.meow();}
    }

    public static <T> boolean checkEquality(Queue<T> queue, int i, int j) {
        if (i >= j || i < 0 || j >= queue.size()) {
            throw new IllegalArgumentException("Некорректные индексы");
        }

        Iterator<T> iterator = queue.iterator();
        int index = 0;
        T firstValue = null;

        while (iterator.hasNext()) {
            T current = iterator.next();

            if (index == i) {firstValue = current;}

            if (index >= i && index <= j) {
                if (!current.equals(firstValue)) {return false;}
            }

            if (index > j) break;

            index++;
        }
        return true;
    }
}
