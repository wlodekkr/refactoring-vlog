package pl.refactoring.tutor.testsrefactoring;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class FacilityPayment {
    private final String facilityName;
    private final double facilityPrice;
    private final int facilityPoints;

    public FacilityPayment(String facilityName, double facilityPrice, int facilityPoints) {
        this.facilityName = facilityName;
        this.facilityPrice = facilityPrice;
        this.facilityPoints = facilityPoints;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public double getFacilityPrice() {
        return facilityPrice;
    }

    public int getFacilityPoints() {
        return facilityPoints;
    }
}
