package Koth;

public class MeowCount implements Meowable {
    private final Meowable meowable;
    private int MeowCount;

    public int getMeowCount() { return MeowCount; }
    public void setMeowCount(int MeowCount) { this.MeowCount = MeowCount; }

    public MeowCount(Meowable meowable) { this.meowable = meowable; MeowCount = 0; }

    @Override
    public void meow() {
        meowable.meow();
        MeowCount++;
    }

    @Override
    public String toString() { return meowable + ", мяукал " + MeowCount + " раз"; }
}
