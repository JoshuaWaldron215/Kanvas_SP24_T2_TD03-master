package model.modulecontent;

import model.AssignmentSubmission;
import model.AssignmentSubmissionFileType;
import model.AssignmentSubmissionStatus;
import util.KanvasDateTime;
import util.StringUtil;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Assignment {
    private List<AssignmentSubmission> submissions = new ArrayList<>();
    private boolean isPublished;
    private LocalDateTime dueDateTime;
    private LocalDateTime availableUntilDateTime;
    private AssignmentSubmissionFileType submissionType;
    private String name;
    private String instructions;

    public Assignment(String name) {
        this.name = name;
    }

    private Assignment() {
    }

    public String getName() {
        return name;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public void setPublished(boolean published) {
        isPublished = published;
    }

    public void setSubmissionType(AssignmentSubmissionFileType submissionType) {
        this.submissionType = submissionType;
    }

    public LocalDateTime getAvailableUntilDateTime() {
        return availableUntilDateTime;
    }

    public void setAvailableUntilDateTime(String availableUntilDateTime) {
        setAvailableUntilDateTime(KanvasDateTime.now(availableUntilDateTime));
    }

    public void setAvailableUntilDateTime(LocalDateTime availableUntilDateTime) {
        this.availableUntilDateTime = availableUntilDateTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(String dueDateTime) {
        setDueDateTime(KanvasDateTime.now(dueDateTime));
    }

    public void setDueDateTime(LocalDateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public boolean isClosed() {
        // An assignment is "closed" if the current date is past the available-until date-time
        LocalDateTime now = KanvasDateTime.now();
        return (now.isAfter(availableUntilDateTime));
    }

    public AssignmentSubmissionStatus submit(AssignmentSubmission submission) {
        if (!isPublished) {
            return AssignmentSubmissionStatus.NOT_PUBLISHED;
        }

        if (isClosed()) {
            return AssignmentSubmissionStatus.CLOSED;
        }


        String filePath = submission.getFilePath();
        if (!StringUtil.hasContent(submission.getFilePath())) {
            return AssignmentSubmissionStatus.NO_FILEPATH;
        }

        int dotPosition = filePath.lastIndexOf(".");
        if (dotPosition == 0) {
            return AssignmentSubmissionStatus.INVALID_FILE_TYPE;
        }

        String fileExtension = filePath.substring(dotPosition + 1); // +1 because we don't want the dot
        try {
            AssignmentSubmissionFileType.valueOf(fileExtension.toUpperCase());
        } catch (Exception e) {
            return AssignmentSubmissionStatus.INVALID_FILE_TYPE;
        }

        File submissionFile = new File(submission.getFilePath());
        if (!submissionFile.exists()) {
            return AssignmentSubmissionStatus.FILE_MISSING;
        }

        submissions.add(submission);
        submission.setAssignment(this);
        submission.setSubmissionDateTime(KanvasDateTime.now());

        // If we got this far, the submission was successful
        return AssignmentSubmissionStatus.SUCCESS;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
