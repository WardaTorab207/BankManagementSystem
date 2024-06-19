package Inheritance;

public class Person {
    protected  String name;
    protected String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
        this.name = "Warda";
        this.address = "address";
    }
}