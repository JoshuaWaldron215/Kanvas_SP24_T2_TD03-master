package util;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * A way to create LocalDateTime objects via dependency injection
 * <p>
 * Helpful to simulate future/past times, for testing and investigating
 */
public class KanvasDateTime {
    private static Clock kanvasClock = null;

    private KanvasDateTime() {
    }

    public static void setClock(Clock dependencyInjectionClock) {
        kanvasClock = dependencyInjectionClock;
    }

    private static Clock createClock(String dateTime) {
        return Clock.fixed(Instant.parse(dateTime + "Z"), ZoneId.of("Z"));
    }

    private static Clock createClock(LocalDateTime localDateTime) {
        return createClock(localDateTime.toString());
    }

    public static void setClock(LocalDateTime localDateTime) {
        setClock(createClock(localDateTime));
    }

    public static void setClock(String dateTime) {
        setClock(createClock(dateTime));
    }

    public static void switchToSystemClock() {
        kanvasClock = null;
    }

    public static LocalDateTime now(String dateTime) {
        Clock clock = createClock(dateTime);
        return now(clock);
    }

    public static LocalDateTime now() {
        return now(kanvasClock);
    }

    public static LocalDateTime now(Clock clock) {
        if (clock != null) {
            return LocalDateTime.now(clock);
        } else {
            return LocalDateTime.now();
        }

    }
}