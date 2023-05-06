package pl.refactoring.testsrefactoring.pricing;

import pl.refactoring.testsrefactoring.Pricing;
import pl.refactoring.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.testsrefactoring.points.HourlyPointsCalculator;

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
