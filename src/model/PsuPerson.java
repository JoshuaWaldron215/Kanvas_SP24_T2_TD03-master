package model;

public class PsuPerson extends Person {
    protected String login; // e.g., pxo4
    protected long PsuId; // e.g., 937841156
    protected Role role;

    public PsuPerson(String lastName, String firstName, String middleName, String login, Role role) {
        super(lastName, firstName, middleName);
        this.login = login;
        this.role = role;
    }

    public String getEmailAddress() {
        return login + "@psu.edu";
    }
}
