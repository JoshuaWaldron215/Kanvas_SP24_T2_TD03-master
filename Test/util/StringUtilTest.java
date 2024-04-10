package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilTest {

    @Test
    void hasContent__pass_whitespace__returns_false() {
        assertFalse(StringUtil.hasContent(""), "empty string");

        assertFalse(StringUtil.hasContent(" "), "one space");
        assertFalse(StringUtil.hasContent("   "), "many spaces");

        assertFalse(StringUtil.hasContent("\t"), "one tab");
        assertFalse(StringUtil.hasContent("\t\t\t"), "many tabs");

        assertFalse(StringUtil.hasContent("  \t \t "), "spaces and tabs");
    }

    @Test
    void hasContent__pass_null__returns_false() {
        assertFalse(StringUtil.hasContent(null));
    }

    @Test
    void hasContent__pass_nonblank__returns_true() {
        assertTrue(StringUtil.hasContent("a"), "one letter");
        assertTrue(StringUtil.hasContent("ab"), "more than one letter");
    }
}