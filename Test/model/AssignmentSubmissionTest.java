package model;

import model.modulecontent.Assignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.KanvasDateTime;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignmentSubmissionTest {
    private Assignment assignment;
    private AssignmentSubmission submission;
    private String basePath = "Test/resources/";
    private String goodFilePath = basePath + "foobar.zip";

    @BeforeEach
    void setupBeforeEach() {
        KanvasDateTime.switchToSystemClock();

        assignment = new Assignment("IA01");
        assignment.setPublished(true);
        assignment.setInstructions("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        assignment.setSubmissionType(AssignmentSubmissionFileType.ZIP);

        submission = new AssignmentSubmission();
    }

    @Test
    void isLate__submit_on_time__returns_false() {
        assignment.setDueDateTime(LocalDateTime.now().plusDays(1));
        assignment.setAvailableUntilDateTime(LocalDateTime.now().plusDays(3));

        submission.setFilePath(goodFilePath);
        assignment.submit(submission);

        boolean actual = submission.isLate();

        assertFalse(actual);
    }

    @Test
    void isLate__submit_after_due_time__returns_true() {
        assignment.setDueDateTime(LocalDateTime.now().plusDays(1));
        assignment.setAvailableUntilDateTime(LocalDateTime.now().plusDays(3));
        KanvasDateTime.setClock(assignment.getDueDateTime().plusSeconds(1));

        submission.setFilePath(goodFilePath);
        assignment.submit(submission);

        boolean actual = submission.isLate();

        assertTrue(actual);
    }
}