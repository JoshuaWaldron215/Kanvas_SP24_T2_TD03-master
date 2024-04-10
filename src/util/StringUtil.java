package util;

public class StringUtil {
    public static boolean hasContent(String s) {
        return !((s == null) || s.trim().isEmpty());
    }
}
