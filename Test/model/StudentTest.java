package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentTest {
    static Student student1;
    static Student student2;

    @BeforeAll
    static void setupBeforeAll() {
        student1 = new Student("Szyslak", "Moe", "", "mxs5123");
        student2 = new Student("Jagger", "Michael", "Philip", "mpj5789");
    }

    @Test
    void testToString__no_middle_name__correct_full_name() {
        assertEquals("Moe Szyslak (mxs5123@psu.edu)", student1.toString());
    }

    @Test
    void testToString__has_middle_name__correct_full_name() {
        assertEquals("Michael P. Jagger (mpj5789@psu.edu)", student2.toString());
    }

}
