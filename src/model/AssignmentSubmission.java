package model;

import model.modulecontent.Assignment;
import util.GradeUtil;

import java.time.LocalDateTime;

public class AssignmentSubmission {
    private Assignment assignment;
    private Student student;

    private double percentageGrade;
    private String text;

    private String filePath;
    private LocalDateTime submissionDateTime;

    public void setSubmissionDateTime(LocalDateTime submissionDateTime) {
        this.submissionDateTime = submissionDateTime;
    }

    public boolean isLate() {
        return GradeUtil.isLate(assignment.getDueDateTime(), submissionDateTime);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
