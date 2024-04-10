package model.modulecontent;

import model.QuizAnswer;
import model.QuizQuestion;
import model.QuizSubmission;
import model.StudentQuizAnswer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class QuizTest {
    static Quiz quiz;

    @BeforeEach
    void setupBeforeEach() {
        quiz = new Quiz("Triangles");

        QuizQuestion question;

        question = new QuizQuestion("How many sides does a triangle have?", 10);
        question.addAnswer(new QuizAnswer("1", false));
        question.addAnswer(new QuizAnswer("2", false));
        question.addAnswer(new QuizAnswer("3", true));
        quiz.addQuestion(question);

        question = new QuizQuestion("How many sides does a square have?", 15);
        question.addAnswer(new QuizAnswer("1", false));
        question.addAnswer(new QuizAnswer("2", false));
        question.addAnswer(new QuizAnswer("3", false));
        question.addAnswer(new QuizAnswer("4", true));
        quiz.addQuestion(question);

    }

    @Test
    void gradeQuiz__answer_all_correct__score_equals_total() {
        QuizSubmission quizSubmission = new QuizSubmission(quiz);

        for (QuizQuestion question : quiz.getQuestions()) {
            for (QuizAnswer answer : question.getAnswers()) {
                if (answer.getIsCorrect()) {
                    StudentQuizAnswer studentAnswer = new StudentQuizAnswer(answer);
                    quizSubmission.answer(question, studentAnswer);
                }
            }
        }

        int expected = 25;
        int actual = quiz.gradeQuiz(quizSubmission);
        assertEquals(expected, actual);

    }

    @Test
    void gradeQuiz__get_one_wrong__score_is_correct() {
        QuizSubmission quizSubmission = new QuizSubmission(quiz);

        int incorrectPoints = 0;
        boolean firstQuestion = true;
        for (QuizQuestion question : quiz.getQuestions()) {
            if (firstQuestion) {
                incorrectPoints += question.getPoints();
                firstQuestion = false;
                continue;
            }
            for (QuizAnswer answer : question.getAnswers()) {
                if (answer.getIsCorrect()) {
                    StudentQuizAnswer studentAnswer = new StudentQuizAnswer(answer);
                    quizSubmission.answer(question, studentAnswer);
                }
            }
        }

        int expected = quiz.getTotalPoints() - incorrectPoints;
        int actual = quiz.gradeQuiz(quizSubmission);
        assertEquals(expected, actual);

    }

    @Test
    void getTotalPoints__create_quiz__points_match_total() {
        assertEquals(25, quiz.getTotalPoints());
    }
}