package util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class GradeUtil {
    private static final int[] PENALTY_POINTS = new int[]{
            15, //  15 points within 1st 24 hours
            25, //  25 points within 2nd 24 hours
            100 // 100 points within after 48 hours
    };

    public static String percentageGradeToLetter(double percent) {
        if (percent >= 93.0) return "A";
        if (percent >= 90.0) return "A-";
        if (percent >= 87.0) return "B+";
        if (percent >= 83.0) return "B";
        if (percent >= 80.0) return "B-";
        if (percent >= 77.0) return "C+";
        if (percent >= 70.0) return "C";
        if (percent >= 60.0) return "D";
        return "F";
    }

    public static boolean isLate(LocalDateTime dueDateTime, LocalDateTime submittedDateTime) {
        // WARNING: Do not use calcPenaltyPercentPoints method in here
        return submittedDateTime.isAfter(dueDateTime);
    }

    public static int calcPenaltyPercentPoints(LocalDateTime dueDateTime, LocalDateTime submittedDateTime) {
        // WARNING: Do not use isLate method in here

        long secondsLate = ChronoUnit.SECONDS.between(dueDateTime, submittedDateTime);

        double daysLate = secondsLate / (24.0 * 60 * 60);

        for (int milestoneDay = PENALTY_POINTS.length; milestoneDay >= 0; milestoneDay--) {
            if (daysLate > milestoneDay) {
                return PENALTY_POINTS[milestoneDay];
            }
        }

        return 0;

    }
}
