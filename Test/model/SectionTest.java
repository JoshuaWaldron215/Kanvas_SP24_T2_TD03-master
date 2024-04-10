package model;

import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.CreateSampleSection;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SectionTest {
    static Section section;
    static Student student1;
    static Student student2;

    @BeforeEach
    void setupBeforeEach() {
        section = CreateSampleSection.initIst261();

        student1 = new Student("Smith", "Pat", "Jane", "pjs5123");
        student2 = new Student("Doe", "John", "", "jxd123");

        section.addStudents(Arrays.asList(
                student1,
                student2
        ));
    }

    @Test
    void addStudent__pass_new_student__count_increases() {
        Student newStudent = new Student("Simpson", "Homer", "Jay", "hjs5245");
        int origCount = section.studentCount();
        section.addStudent(newStudent);

        int expected = origCount + 1;
        int actual = section.studentCount();
        assertEquals(expected, actual);
    }

    @Test
    void findStudent__pass_existing_student_login__returns_student() {
        String psuLogin = "jxd123";
        Student foundStudent = section.findStudent(psuLogin);
        assertEquals(student2, foundStudent);
    }

    @Test
    void findStudent__pass_nonexisting_student_login__returns_null() {
        String psuLogin = "blah";
        Student foundStudent = section.findStudent(psuLogin);
        assertNull(foundStudent);
    }

    @Test
    void addStudent__pass_student__student_found() {
        Student newStudent = new Student("Jingleheimer Schmidt", "John", "Jacob", "jjj5123");

        assertFalse(section.isEnrolled(newStudent.getLogin()));
        section.addStudent(newStudent);
        assertTrue(section.isEnrolled(newStudent.getLogin()));
    }

    @Test
    void addStudent__pass_existing_student__throws_exception() {
        assertTrue(section.isEnrolled(student1.getLogin()));

        /*
         * We didn't cover this in class.  But it's a way that you can
         * ensure that an exception will be thrown when expected.
         *
         * Here, we want an exception if we try to add a student that's already
         * in the class.
         */
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            section.addStudent(student1);
        });
    }

    @Test
    void dropStudent__pass_student__student_not_found() {
        assertTrue(section.isEnrolled(student1.getLogin()));
        section.dropStudent(student1);
        assertFalse(section.isEnrolled(student1.getLogin()));
    }

    @Test
    void deleteAnnouncement__pass_announcement__then_not_in_collection() {
        // Get the first one
        Announcement deleted = section.getAnnouncements().iterator().next();
        section.deleteAnnouncement(deleted);
        for(Announcement a : section.getAnnouncements()) {
            assertNotEquals(deleted, a, String.format("'%s' should be deleted", deleted.getTopic()));
        }
    }

    @Test
    void deleteAssignment__pass_assignment__then_not_in_collection() {
        // Get the first one
        Assignment deleted = section.getAssignments().iterator().next();
        section.deleteAssignment(deleted);
        for(Assignment a : section.getAssignments()) {
            assertNotEquals(deleted, a, String.format("'%s' should be deleted", deleted.getName()));
        }
    }

    @Test
    void deleteQuiz__pass_quiz__then_not_in_collection() {
        // Get the first one
        Quiz deleted = section.getQuizzes().iterator().next();
        section.deleteQuiz(deleted);
        for(Quiz q : section.getQuizzes()) {
            assertNotEquals(deleted, q, String.format("'%s' should be deleted", deleted.getName()));
        }
    }
}
