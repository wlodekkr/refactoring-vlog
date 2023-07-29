package pl.refactoring.vlog02.todo.pricing;

import pl.refactoring.vlog02.todo.Pricing;
import pl.refactoring.vlog02.todo.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.todo.points.FixedPointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SwimmingPoolPricing extends Pricing {

    public SwimmingPoolPricing() {
        super(new EntryPeriodFeeCalculator(3.0, 1, 1.5),
                new FixedPointsCalculator());
    }

}
