package pl.refactoring.dirty.strategies;

import java.time.*;

public class WorkRecord {

    private final Instant beginOfWork;
    private final Instant endOfWork;
    private final ZoneId zoneId = ZoneId.of("Europe/Paris");

    private WorkRecord(Instant beginOfWork, Instant endOfWork) {
        this.beginOfWork = beginOfWork;
        this.endOfWork = endOfWork;
    }

    public static WorkRecord registerWork(Instant begin, Instant end) {
        return new WorkRecord(begin, end);
    }

    Duration getDuration() {
        return Duration.between(beginOfWork, endOfWork);
    }

    Duration getNighttimeDuration(NightTimeRegulation nightTimeConfig) {
        LocalDateTime beginOfWork = this.beginOfWork.atZone(zoneId).toLocalDateTime();
        LocalDateTime endOfWork = this.endOfWork.atZone(zoneId).toLocalDateTime();

        LocalDateTime beginOfCurrentNightTimeRegulation = LocalDateTime.of(beginOfWork.toLocalDate(),
                LocalTime.of(nightTimeConfig.beginHourOfDay(), 0));

        LocalDateTime endOfPreviousNightTimeRegulation = LocalDateTime.of(beginOfWork.toLocalDate(),
                LocalTime.of(nightTimeConfig.endHourOfDay(), 0));

        LocalDateTime endOfCurrentNightTimeRegulation = endOfPreviousNightTimeRegulation.plusDays(1);

        // No Nighttime
        if (beginOfWork.isBefore(beginOfCurrentNightTimeRegulation) &&
                ! beginOfWork.isBefore(endOfPreviousNightTimeRegulation) &&
                endOfWork.isBefore(beginOfCurrentNightTimeRegulation) &&
                ! endOfWork.isBefore(endOfPreviousNightTimeRegulation)) {
            return Duration.ZERO;
        }

        // Full Nighttime
        if (! beginOfWork.isBefore(beginOfCurrentNightTimeRegulation) &&
                ! endOfWork.isAfter(endOfCurrentNightTimeRegulation)) {
            return Duration.between(this.beginOfWork, this.endOfWork);
        }

        LocalDateTime beginOfActualNightTimeWork = this.beginOfWork.atZone(zoneId).toLocalDateTime();
        LocalDateTime endOfActualNightTimeWork = this.endOfWork.atZone(zoneId).toLocalDateTime();

        // Ending Nighttime
        if (beginOfActualNightTimeWork.isBefore(beginOfCurrentNightTimeRegulation)
                && endOfActualNightTimeWork.isAfter(beginOfCurrentNightTimeRegulation)) {
            beginOfActualNightTimeWork = beginOfCurrentNightTimeRegulation;
        }

        // Beginning Nighttime same evening
        if (endOfActualNightTimeWork.isAfter(endOfCurrentNightTimeRegulation)
                && beginOfActualNightTimeWork.isBefore(endOfCurrentNightTimeRegulation)) {
            endOfActualNightTimeWork = endOfCurrentNightTimeRegulation;
        }

        // Beginning Nighttime very early morning
        if (beginOfActualNightTimeWork.isBefore(endOfPreviousNightTimeRegulation)
                && endOfActualNightTimeWork.isAfter(endOfPreviousNightTimeRegulation)) {
            endOfActualNightTimeWork = endOfPreviousNightTimeRegulation;
        }

        return Duration.between(beginOfActualNightTimeWork, endOfActualNightTimeWork);
    }

    public Instant getBeginOfWork() {
        return beginOfWork;
    }

    public Instant getEndOfWork() {
        return endOfWork;
    }
}
