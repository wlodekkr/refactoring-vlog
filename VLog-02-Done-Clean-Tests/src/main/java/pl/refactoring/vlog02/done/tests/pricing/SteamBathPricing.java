package pl.refactoring.vlog02.done.tests.pricing;

import pl.refactoring.vlog02.done.tests.Pricing;
import pl.refactoring.vlog02.done.tests.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.tests.points.HourlyPointsCalculator;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SteamBathPricing extends Pricing {

    public SteamBathPricing() {
        super(new EntryPeriodFeeCalculator(0.0, 0, 5.0),
                new HourlyPointsCalculator());
    }

}
