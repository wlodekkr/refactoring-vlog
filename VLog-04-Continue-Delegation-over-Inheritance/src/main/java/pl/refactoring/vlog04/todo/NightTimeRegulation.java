package pl.refactoring.vlog04.todo;

/*
 * We do not need minutes precision at this time
 *
 * Night hours are defined as 8 consecutive hours between 9PM and 7AM
 *
 */
public record NightTimeRegulation(int beginHourOfDay, int beginMinute) {
    public static final NightTimeRegulation NIGHT_SHIFT_21_5 = new NightTimeRegulation(21,0);
    public static final NightTimeRegulation NIGHT_SHIFT_22_6 = new NightTimeRegulation(22,0);
    public static final NightTimeRegulation NIGHT_SHIFT_23_7 = new NightTimeRegulation(23,0);

    public NightTimeRegulation {
        if (beginHourOfDay < 21 || beginHourOfDay > 23)
            throw new IllegalArgumentException();

        if (beginHourOfDay == 23 && beginMinute != 0)
            throw new IllegalArgumentException();
    }

    int endHourOfDay(){
        return (beginHourOfDay + 8) % 24;
    }

    int endMinute(){
        return beginMinute;
    }
}
