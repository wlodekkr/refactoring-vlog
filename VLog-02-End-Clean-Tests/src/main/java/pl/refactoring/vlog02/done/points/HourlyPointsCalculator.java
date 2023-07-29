package pl.refactoring.vlog02.done.points;

import pl.refactoring.vlog02.done.PointsCalculator;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class HourlyPointsCalculator implements PointsCalculator {
    public HourlyPointsCalculator() {
    }

    @Override
    public int countPoints(int hours) {
        return 150 * hours;
    }
}