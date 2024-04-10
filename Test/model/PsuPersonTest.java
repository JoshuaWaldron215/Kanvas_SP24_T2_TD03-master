package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PsuPersonTest {
    PsuPerson psuPerson;

    @BeforeEach
    void setupBeforeEach() {
        psuPerson = new PsuPerson("O'Connell", "Philip", "J", "pxo4", Role.TEACHER);
    }

    @Test
    void getEmailAddress__pass_nothing__returns_email_address() {
        String expected = "pxo4@psu.edu";
        String actual = psuPerson.getEmailAddress();
        assertEquals(expected, actual);
    }
}