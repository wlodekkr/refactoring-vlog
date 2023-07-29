package pl.refactoring.vlog02.todo.pricing;

import pl.refactoring.vlog02.todo.Pricing;
import pl.refactoring.vlog02.todo.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.todo.points.HourlyPointsCalculator;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SteamBathPricing extends Pricing {

    public SteamBathPricing() {
        super(new EntryPeriodFeeCalculator(0.0, 0, 5.0),
                new HourlyPointsCalculator());
    }

}
