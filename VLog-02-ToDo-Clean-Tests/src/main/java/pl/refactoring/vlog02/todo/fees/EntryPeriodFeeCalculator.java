package pl.refactoring.vlog02.todo.fees;

import pl.refactoring.vlog02.todo.FeeCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class EntryPeriodFeeCalculator implements FeeCalculator {

    private final double entryFee;
    private final int entryHours;
    private final double hourlyPrice;

    public EntryPeriodFeeCalculator(double entryFee, int entryHours, double hourlyPrice) {
        this.entryFee = entryFee;
        this.entryHours = entryHours;
        this.hourlyPrice = hourlyPrice;
    }

    @Override
    public double calculateFee(int hours) {
        double singlePrice = 0.0;

        singlePrice += entryFee;
        if (hours > entryHours) {
            singlePrice += (hours - entryHours) * hourlyPrice;
        }
        return singlePrice;
    }
}