package model;

import util.StringUtil;

import java.time.LocalDateTime;

public class Student extends PsuPerson {
    protected LocalDateTime lastActivity;

    public Student(String lastName, String firstName, String middleName, String login) {
        super(lastName, firstName, middleName, login, Role.STUDENT);
    }

    public String getLogin() {
        return login;
    }

    public String toString() {
        String middleAbbreviated = "";
        if (StringUtil.hasContent(middleName)) {
            middleAbbreviated = middleName.charAt(0) + ". ";
        }

        return String.format("%s %s%s (%s)", firstName, middleAbbreviated, lastName, getEmailAddress());


    }
}
