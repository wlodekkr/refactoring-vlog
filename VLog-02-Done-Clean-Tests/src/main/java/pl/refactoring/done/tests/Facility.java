package pl.refactoring.done.tests;

import pl.refactoring.done.tests.pricing.GymPricing;
import pl.refactoring.done.tests.pricing.SteamBathPricing;
import pl.refactoring.done.tests.pricing.SwimmingPoolPricing;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Facility {
    public static final int GYM = 0;
    public static final int STEAM_BATH = 1;
    public static final int SWIMMING_POOL = 2;

    private String name;
    private Pricing pricing;

    public Facility(String name, int type) {
        this.name = name;
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    double countPrice(final int hours) {
        return pricing.countPrice(hours);
    }

    int countPoints(final int hours) {
        Pricing pricing = this.pricing;

        return pricing.countPoints(hours);
    }

    // TODO : Method promised to be removed
    private void setType(int type) {
        switch (type) {
            case GYM:
                pricing = new GymPricing();
                break;
            case STEAM_BATH:
                pricing = new SteamBathPricing();
                break;
            case SWIMMING_POOL:
                pricing = new SwimmingPoolPricing();
                break;
        }
    }
}