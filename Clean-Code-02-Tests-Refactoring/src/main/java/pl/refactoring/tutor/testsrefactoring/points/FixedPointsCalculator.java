package pl.refactoring.tutor.testsrefactoring.points;

import pl.refactoring.tutor.testsrefactoring.PointsCalculator;

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