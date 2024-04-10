package model;


public class Person {
    protected String firstName;
    protected String middleName;
    protected String lastName;

    public Person(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

}
