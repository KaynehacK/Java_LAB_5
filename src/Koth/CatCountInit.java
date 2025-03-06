package Koth;

public class CatCountInit {
    public static Meowable InitiateCountedCat(String name) {
        return new MeowCount(new Cat(name));
    }
}
