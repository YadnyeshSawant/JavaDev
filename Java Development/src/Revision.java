

public class Revision {

    String name;
    int number;

    public Revision(String name, int number) {
        this.name = name;
        this.number = number;
    }

    void display() {
        System.out.println("The details from the class Revision");
        System.out.println(this.name + "\n" + this.number + "\n");
    }

    public static void main(String[] args) {
        Revision rev = new Revision("Yadnyesh", 8887246);
        rev.display();
    }
}