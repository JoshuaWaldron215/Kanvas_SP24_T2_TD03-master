package util;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GradeUtilTest {

    @Test
    void percentageGradeToLetter__pass_percentage__returns_A() {
        Map<String, double[]> testData = new HashMap<>();
        testData.put("A", new double[]{100, 93});
        testData.put("A-", new double[]{92.99, 90});
        testData.put("B+", new double[]{89.99, 87});
        testData.put("B", new double[]{86.99, 83});
        testData.put("B-", new double[]{82.99, 80});
        testData.put("C+", new double[]{79.99, 77});
        testData.put("C", new double[]{76.99, 70});
        testData.put("D", new double[]{69.99, 60});
        testData.put("F", new double[]{59.99, 0, 1, 59});

        for (Map.Entry<String, double[]> pair : testData.entrySet()) {
            String expected = pair.getKey();
            for (double percent : pair.getValue()) {
                String actual = GradeUtil.percentageGradeToLetter(percent);
                assertEquals(expected, actual, String.format("%.2f should be '%s'", percent, expected));
            }

        }
    }

    @Test
    void isLate__submit_early__returns_false() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T17:59:59");

        boolean actual = GradeUtil.isLate(dueDateTime, submitDateTime);
        assertFalse(actual);
    }

    @Test
    void isLate__submit_late__returns_true() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T18:00:01");

        boolean actual = GradeUtil.isLate(dueDateTime, submitDateTime);
        assertTrue(actual);
    }

    @Test
    void isLate__submit_exactly_on_time__returns_false() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T18:00:00");

        boolean actual = GradeUtil.isLate(dueDateTime, submitDateTime);
        assertFalse(actual);
    }

    @Test
    void calcPenaltyPercentPoints__submit_early__no_penalty() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T17:59:59");

        int expected = 0;
        int actual = GradeUtil.calcPenaltyPercentPoints(dueDateTime, submitDateTime);
        assertEquals(expected, actual);
    }

    @Test
    void calcPenaltyPercentPoints__submit_on_time__no_penalty() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T18:00:00");

        int expected = 0;
        int actual = GradeUtil.calcPenaltyPercentPoints(dueDateTime, submitDateTime);
        assertEquals(expected, actual);
    }

    @Test
    void calcPenaltyPercentPoints__submit_one_second_late__correct_penalty() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-03T18:00:01");

        int expected = 15;
        int actual = GradeUtil.calcPenaltyPercentPoints(dueDateTime, submitDateTime);
        assertEquals(expected, actual);
    }

    @Test
    void calcPenaltyPercentPoints__submit_over_one_day_late__correct_penalty() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-04T18:00:01");

        int expected = 25;
        int actual = GradeUtil.calcPenaltyPercentPoints(dueDateTime, submitDateTime);
        assertEquals(expected, actual);
    }

    @Test
    void calcPenaltyPercentPoints__submit_over_two_days_late__correct_penalty() {
        LocalDateTime dueDateTime = KanvasDateTime.now("2021-11-03T18:00:00");
        LocalDateTime submitDateTime = KanvasDateTime.now("2021-11-05T18:00:01");

        int expected = 100;
        int actual = GradeUtil.calcPenaltyPercentPoints(dueDateTime, submitDateTime);
        assertEquals(expected, actual);
    }
}
