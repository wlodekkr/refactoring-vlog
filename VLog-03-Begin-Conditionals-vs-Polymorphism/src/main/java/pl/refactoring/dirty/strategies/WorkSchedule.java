package pl.refactoring.dirty.strategies;

/**
 * Maybe it should be part 2
 */
public enum WorkSchedule {
    EIGHT_HOURS_SHIFT(8, true),
    TWELVE_HOURS_SHIFT(12, false);

    WorkSchedule(int durationInHours, boolean overtimeAllowance) {
        this.durationInHours = durationInHours;
        this.overtimeAllowance = overtimeAllowance;
    }

    private int durationInHours;

    private boolean overtimeAllowance;
}
