package pl.refactoring.done.tests;

import java.util.List;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class TotalPayment {
    private String clientName;
    private final double totalPrice;
    private final int loyaltyPoints;
    private final List<FacilityPayment> facilityPayments;

    public TotalPayment(String clientName, double totalPrice, int loyaltyPoints, List<FacilityPayment> facilityPayments) {
        this.clientName = clientName;
        this.totalPrice = totalPrice;
        this.loyaltyPoints = loyaltyPoints;
        this.facilityPayments = facilityPayments;
    }

    public String getClientName() {
        return clientName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public List<FacilityPayment> getFacilityPayments() {
        return facilityPayments;
    }
}
