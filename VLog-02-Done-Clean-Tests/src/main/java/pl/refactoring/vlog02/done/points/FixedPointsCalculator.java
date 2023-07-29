package pl.refactoring.vlog02.done.points;

import pl.refactoring.vlog02.done.PointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class FixedPointsCalculator implements PointsCalculator {
    public FixedPointsCalculator() {
    }

    @Override
    public int countPoints(int hours) {
        return 100;
    }
}