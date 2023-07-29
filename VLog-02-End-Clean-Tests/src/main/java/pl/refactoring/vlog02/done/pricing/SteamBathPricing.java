package pl.refactoring.vlog02.done.pricing;

import pl.refactoring.vlog02.done.Pricing;
import pl.refactoring.vlog02.done.fees.EntryPeriodFeeCalculator;
import pl.refactoring.vlog02.done.points.HourlyPointsCalculator;

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
