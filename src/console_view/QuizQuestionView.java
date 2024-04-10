package console_view;

import model.QuizQuestion;

import static console_view.ViewUtil.readNonBlankStringFromKeyboard;
import static console_view.ViewUtil.userInputInt;

public class QuizQuestionView {

    public static QuizQuestion createQuizQuestion() {
        // TODO 03 - [console_view.QuizQuestionView.createQuizQuestion] - Write this method
        /*
         * Prompt the user for the quiz text and point value.
         * We're not dealing with the answers in this deliverable
         * Create the QuizQuestion object, and return it.
         *
         * This can be done in about 4 lines.  If you find you're doing more
         * than that, look around for an existing utility method that will make
         * it easier.
         */
        System.out.print("Enter the quiz text: ");
        String text = readNonBlankStringFromKeyboard("Enter a non-blank text");

        System.out.print("Enter the point value: ");
        int points = userInputInt("Enter a positive integer");

        return new QuizQuestion(text, points);
    }

    /**
     * Displays the question number and quiz question
     * <p>
     *     Retrieves the question number and then displays the question and
     *      the total points the question is worth
     * </p>
     * @param questionNumber
     * @param question
     * @author Kayla Swenson (Kas7927@psu.edu)
     */

    public static void display(int questionNumber, QuizQuestion question) {
        // TODO 04 - [console_view.QuizQuestionView.display] - Write this method.  Ensure output matches assignment
        /*
         * This can be done in one line
         */
        System.out.println(questionNumber + ")" + "[" + question.getPoints() + "] - " + question.getText());
    }
}
