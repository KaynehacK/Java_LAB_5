package Input;

import java.util.Scanner;
import static java.lang.System.out;

public class ForceInput {
    public static int InputInt(int LoLim, int HiLim) {
        Scanner in = new Scanner(System.in);
        int Res;
        while (true) {
            try {
                Res = in.nextInt();
                if ( LoLim <= Res && Res <= HiLim ) return Res;
                else {
                    out.printf("Число выходит за ограничения. Введите снова.\n");
                    continue;
                }
            } catch (Exception e) {
                out.printf("Исключение: " + e + "\nНекорректный ввод. Введите снова.\n");
                break;
            }
        }
        return 0;
    }

    public static int InputInt() {
        return InputInt(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
