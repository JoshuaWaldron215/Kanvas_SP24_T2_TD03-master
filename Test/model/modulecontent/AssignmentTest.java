package model.modulecontent;

import model.AssignmentSubmission;
import model.AssignmentSubmissionFileType;
import model.AssignmentSubmissionStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.KanvasDateTime;

import java.io.File;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static model.AssignmentSubmissionStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
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
        assignment.setDueDateTime(LocalDateTime.now().plusMinutes(5));
        assignment.setAvailableUntilDateTime(assignment.getDueDateTime().plusDays(2));
        assignment.setSubmissionType(AssignmentSubmissionFileType.ZIP);

        submission = new AssignmentSubmission();
    }

    @Test
    void submit__test_varieties() {
        List<Map.Entry<String, AssignmentSubmissionStatus>> tests = new ArrayList<>();
        tests.add(new AbstractMap.SimpleEntry("", NO_FILEPATH));
        tests.add(new AbstractMap.SimpleEntry(null, NO_FILEPATH));
        tests.add(new AbstractMap.SimpleEntry(basePath + "does_not_exist.zip", FILE_MISSING));
        tests.add(new AbstractMap.SimpleEntry(basePath + "foobar.xlsx", INVALID_FILE_TYPE));
        tests.add(new AbstractMap.SimpleEntry(basePath + "foobar", INVALID_FILE_TYPE));
        tests.add(new AbstractMap.SimpleEntry(basePath + "somefile.docx", SUCCESS));
        tests.add(new AbstractMap.SimpleEntry(basePath + "something.mp4", SUCCESS));
        tests.add(new AbstractMap.SimpleEntry(goodFilePath, SUCCESS));

        for (Map.Entry test : tests) {
            String file = (String) test.getKey();
            String filePath;
            if ((file != null) && file.contains(basePath)) {
                File fileHandle = new File((String) test.getKey());
                filePath = fileHandle.getAbsolutePath();
            } else {
                filePath = file;
            }
            submission.setFilePath(filePath);

            AssignmentSubmissionStatus expected = (AssignmentSubmissionStatus) test.getValue();
            AssignmentSubmissionStatus actual = assignment.submit(submission);

            assertEquals(expected, actual, String.format("'%s' should be '%s'", filePath, expected));
        }
    }

    @Test
    void submit__past_availability__returns_CLOSED() {
        assignment.setAvailableUntilDateTime(LocalDateTime.now());
        KanvasDateTime.setClock(assignment.getAvailableUntilDateTime().plusDays(1));

        assertTrue(assignment.isClosed());
    }

    @Test
    void submit__during_availability__returns_not_CLOSED() {
        assignment.setAvailableUntilDateTime(LocalDateTime.now());
        KanvasDateTime.setClock(assignment.getAvailableUntilDateTime().minusDays(1));

        assertFalse(assignment.isClosed());
    }

    @Test
    void submit__after_availability__returns_CLOSED() {
        assignment.setAvailableUntilDateTime(LocalDateTime.now());
        KanvasDateTime.setClock(assignment.getAvailableUntilDateTime().plusSeconds(1));

        submission.setFilePath(goodFilePath);

        AssignmentSubmissionStatus expected = CLOSED;
        AssignmentSubmissionStatus actual = assignment.submit(submission);

        assertEquals(expected, actual);
    }


    @Test
    void submit__to_unpublished_assignment__returns_NOT_PUBLISHED() {
        assignment.setPublished(false);
        submission.setFilePath(goodFilePath);

        AssignmentSubmissionStatus expected = NOT_PUBLISHED;
        AssignmentSubmissionStatus actual = assignment.submit(submission);

        assertEquals(expected, actual);
    }
}