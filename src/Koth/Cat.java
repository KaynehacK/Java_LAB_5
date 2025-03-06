package Koth;

public class Cat implements Meowable {
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Cat(String name) {this.name = name;}

    public void meow() {
        System.out.println("Meow...");
    }

    @Override
    public String toString() {return "Кот: " + name;}
}
