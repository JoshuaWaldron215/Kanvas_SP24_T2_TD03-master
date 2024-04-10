package util;

/**
 * Additional functionality for StringBuilder
 * <p>
 * Unfortunately, StringBuilder doesn't have an appendLine, so we have to do it ourselves.
 * <p>
 * Found this at
 * https://stackoverflow.com/a/59646969/673393
 */
public class StringBuilderPlus {
    private final StringBuilder stringBuilder;

    public StringBuilderPlus() {
        this.stringBuilder = new StringBuilder();
    }

    public <T> StringBuilderPlus append(T t) {
        stringBuilder.append(t);
        return this;
    }

    public <T> StringBuilderPlus append() {
        stringBuilder.append("");
        return this;
    }

    public <T> StringBuilderPlus appendLine() {
        stringBuilder.append("").append(System.lineSeparator());
        return this;
    }

    public <T> StringBuilderPlus appendLine(T t) {
        stringBuilder.append(t).append(System.lineSeparator());
        return this;
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }
}
