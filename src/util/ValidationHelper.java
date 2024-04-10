package util;

public class ValidationHelper {
    public static Double tryParseDouble(String text) {
        try {
            return Double.parseDouble(text);
        } catch (Exception e) {
            return null;
        }
    }

    public static Integer tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Validate a given character is in range
     * <p>
     * Determine if the given character is in an allowed range
     *
     * @param ch    The character being validated
     * @param range The string holding valid characters
     * @return true if the character is in range
     */
    public static boolean isCharInRange(char ch, String range) {
        if (range == null) {
            return false;
        }
        return (range.indexOf(ch) >= 0);
    }

    /**
     * Checks that given string is "Y" or "N"
     *
     * @param str string to be checked
     * @return true if string is "Y" or "N"
     */
    public static boolean isValidYorN(String str) {
        return ("N".equals(str) || "Y".equals(str));
    }

    public static boolean isIntInRange(int value, int start, int end) {
        if (value < start || value > end) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isStringNullOrEmpty(String str) {
        return ((str == null) || (str.isEmpty()));
    }

}
