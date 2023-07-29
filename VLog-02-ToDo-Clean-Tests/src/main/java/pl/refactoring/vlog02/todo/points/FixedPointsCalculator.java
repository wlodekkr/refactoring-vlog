package pl.refactoring.vlog02.todo.points;

import pl.refactoring.vlog02.todo.PointsCalculator;

/**
 * Sources provided under artistic license
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