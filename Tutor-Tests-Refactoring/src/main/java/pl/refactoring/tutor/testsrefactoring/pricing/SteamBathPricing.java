package pl.refactoring.tutor.testsrefactoring.pricing;

import pl.refactoring.tutor.testsrefactoring.fees.EntryPeriodFeeCalculator;
import pl.refactoring.tutor.testsrefactoring.Pricing;
import pl.refactoring.tutor.testsrefactoring.points.HourlyPointsCalculator;

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
