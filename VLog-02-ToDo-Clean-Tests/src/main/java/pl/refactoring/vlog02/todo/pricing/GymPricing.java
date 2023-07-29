package pl.refactoring.vlog02.todo.pricing;

import pl.refactoring.vlog02.todo.Pricing;
import pl.refactoring.vlog02.todo.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.todo.points.FixedPointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GymPricing extends Pricing {

    public GymPricing() {
        super(new EntryPeriodFeeCalculator(4.0, 2, 0.50),
                new FixedPointsCalculator());
    }

}
