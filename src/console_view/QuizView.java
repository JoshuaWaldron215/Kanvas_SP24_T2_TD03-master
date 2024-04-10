package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.QuizQuestion;
import model.modulecontent.Quiz;

import static console_view.ViewUtil.makeUnderline;
import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class QuizView {

    /**
     * Display each question of the quiz using QuizQuestionView.
     * <p>
     * This method iterates through the list of questions in the provided quiz
     * and displays each question with its details using QuizQuestionView.
     * </p>
     * @param quiz The quiz containing the questions to be displayed.
     * @author Mark Jachura (mgj5130@psu.edu)
     */
    public static void display(Quiz quiz) {
        String underline = makeUnderline(quiz.getName());

        System.out.println(underline);
        System.out.println(quiz.getName());
        System.out.println(underline);

        // TODO 05 - [console_view.QuizView.display] - Use QuizQuestionView.display to display each question
        //   It's up to you to pass the correct question number
        int questionNumber = 1;
        for (QuizQuestion question : quiz.getQuestions()) {
            System.out.println("Question " + questionNumber++ + ":");
            QuizQuestionView.display(questionNumber, question);
        }

        System.out.println("console_view.QuizView.display is not done yet");
    }


    public static Quiz createQuiz() {
        // TODO 06 - [console_view.QuizView.createQuiz] - Prompt user for the name of the quiz, and create Quiz object
        Quiz quiz = null;


        // TODO 07 - [console_view.QuizView.createQuiz] - Create the "Create Question" Menu and MenuDisplay




        // TODO 08 - [console_view.QuizView.createQuiz] - Add questions to the quiz
        //   Repeatedly display and choose from the menu.
        //   When user chooses to create another, then use QuizQuestionView.createQuizQuestion to
        //   Create a question, and then add it to the quiz








        System.out.println("console_view.QuizView.createQuiz is not done yet");
        return quiz;
    }
}
