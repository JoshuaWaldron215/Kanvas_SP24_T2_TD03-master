package model;

import model.modulecontent.Quiz;
import util.GradeUtil;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class QuizSubmission {

    private Quiz quiz;

    private LocalDateTime submittedDateTime;
    private int grade;

    private Map<QuizQuestion, StudentQuizAnswer> studentAnswers = new HashMap<>();

    public QuizSubmission(Quiz quiz) {
        this.quiz = quiz;
    }

    public Map<QuizQuestion, StudentQuizAnswer> getStudentAnswers() {
        return Collections.unmodifiableMap(studentAnswers);
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void answer(QuizQuestion question, StudentQuizAnswer studentAnswer) {
        studentAnswers.put(question, studentAnswer);
    }

    public boolean isLate() {
        return GradeUtil.isLate(quiz.getDueDateTime(), submittedDateTime);
    }

    public int calcPenalty() {
        return GradeUtil.calcPenaltyPercentPoints(quiz.getDueDateTime(), submittedDateTime);
    }
}
