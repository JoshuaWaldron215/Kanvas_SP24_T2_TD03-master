package model;


public class StudentQuizAnswer {

    private QuizQuestion question;
    private QuizAnswer studentQuizAnswer;

    public StudentQuizAnswer(QuizAnswer studentAnswer) {
        this.studentQuizAnswer = studentAnswer;
    }

    public QuizQuestion getQuestion() {
        return question;
    }

    public QuizAnswer getAnswer() {
        return studentQuizAnswer;
    }
}
