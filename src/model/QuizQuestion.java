package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizQuestion {
    List<QuizAnswer> answers = new ArrayList<>();
    private String text;
    private int points;
    public QuizQuestion(String text, int points) {
        this.text = text;
        this.points = points;
    }

    public String getText() {
        return text;
    }

    public Iterable<QuizAnswer> getAnswers() {
        return Collections.unmodifiableList(answers);
    }

    public QuizAnswer getCorrectAnswer() {

        for (QuizAnswer answer : answers) {
            if (answer.isCorrect) {
                return answer;
            }
        }
        return null;
    }

    public int getPoints() {
        return points;
    }

    public void addAnswer(QuizAnswer quizAnswer) {
        answers.add(quizAnswer);
    }
}
