package pl.refactoring.vlog04.todo;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static java.time.temporal.ChronoField.DAY_OF_WEEK;

public class TestConstants {
    public static final int MON = 1;
    public static final int TUE = 2;
    public static final int WED = 3;
    public static final int THU = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;
    public static final int SUN = 7;
    public static final ZoneId ZONE_ID = ZoneId.of("Europe/Paris");

    static Instant instantOf(int dayOfWeek, int hour, int minutes) {
        return ZonedDateTime.of(2023, 5, 1, hour, minutes, 0, 0, ZONE_ID)
                .with(DAY_OF_WEEK, dayOfWeek)
                .toInstant();
    }
}
