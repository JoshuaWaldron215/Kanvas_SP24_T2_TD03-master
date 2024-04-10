package console_view;

import util.ValidationHelper;

import java.util.Scanner;

public class ViewUtil {
    public static final Scanner keyboard = new Scanner(System.in);


    public static String readStringFromKeyboard(String prompt) {
        System.out.print(prompt + ": ");

        return keyboard.nextLine();
    }

    public static String readNonBlankStringFromKeyboard(String prompt) {
        String nonblankString;

        while (true) {
            nonblankString = readStringFromKeyboard(prompt);
            if (nonblankString.trim().isEmpty()) {
                System.out.println();
                System.out.println("Cannot be blank");
            } else {
                break;
            }
        }

        return nonblankString;
    }

    public static String strUserInputYorN(String prompt) {
        String userInput;
        while (!ValidationHelper.isValidYorN(userInput = readNonBlankStringFromKeyboard(prompt.trim() + " (Y|N)"))) {
            System.out.println("Invalid input");
        }
        return userInput;
    }

    public static boolean boolUserInputYorN(String prompt) {
        String userInput = strUserInputYorN(prompt.trim() + " ");
        return "y".equals(userInput.toLowerCase());
    }


    public static double userInputDouble(String prompt) {
        Double parsedToDouble = null;

        while (parsedToDouble == null) {
            String userInput = readStringFromKeyboard(prompt);
            parsedToDouble = ValidationHelper.tryParseDouble(userInput);
        }

        return parsedToDouble;
    }

    public static int userInputInt(String prompt) {
        Integer parsedToInt = null;

        while (parsedToInt == null) {
            String userInput = readStringFromKeyboard(prompt);
            parsedToInt = ValidationHelper.tryParseInt(userInput);
        }

        return parsedToInt;
    }

    /**
     * Prompt for user input, and validate in range
     * <p>
     * Repeatedly prompt the user for a character.<p>
     * Ensure that the character is within a range of characters
     * <p>(which is packed into a string)
     *
     * @param prompt Prompt, so the user knows what to type in
     * @param range  Valid characters allowed (e.g., "aeiou")
     * @return In-range character chosen by the user
     */
    public static char userInputChar(String prompt, String range) {

        char userChar = 0;
        while (!ValidationHelper.isCharInRange(userChar, range)) {
            String userInput = readStringFromKeyboard(prompt + " (" + range + ")");
            if (userInput.length() > 0) {
                userChar = userInput.charAt(0);
            }
        }

        return userChar;
    }

    public static String makeUnderline(String s) {
        return s.replaceAll(".", "-");
    }


}
