package model.modulecontent;

import model.QuizQuestion;
import model.QuizSubmission;
import model.StudentQuizAnswer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Quiz extends Content implements IContent {
    private int totalPoints;
    private String name;
    private LocalDateTime dueDateTime;
    private List<QuizQuestion> questions = new ArrayList<>();

    private Quiz() {
    }

    public Quiz(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    }

    int gradeQuiz(QuizSubmission submission) {
        Map<QuizQuestion, StudentQuizAnswer> studentAnswers = submission.getStudentAnswers();

        int totalPointsCorrect = 0;

        for (QuizQuestion question : questions) {
            StudentQuizAnswer studentAnswer = studentAnswers.get(question);
            if (studentAnswer == null) {
                continue;
            }
            if (question.getCorrectAnswer() == studentAnswer.getAnswer()) {
                totalPointsCorrect += question.getPoints();
            }
        }

        return totalPointsCorrect;
    }

    public Iterable<QuizQuestion> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addQuestion(QuizQuestion question) {
        questions.add(question);
        totalPoints += question.getPoints();
    }

    @Override
    public String getTitle() {
        return name;
    }
}
