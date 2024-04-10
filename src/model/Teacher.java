package model;

import java.time.LocalDateTime;

public class Teacher extends PsuPerson {
    protected LocalDateTime lastActivity;

    public Teacher(String lastName, String firstName, String middleName, String login) {
        super(lastName, firstName, middleName, login, Role.TEACHER);
    }

}
