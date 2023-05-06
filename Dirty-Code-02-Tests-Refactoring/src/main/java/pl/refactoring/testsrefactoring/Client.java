package pl.refactoring.testsrefactoring;

import pl.refactoring.testsrefactoring.renderer.HtmlRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class Client {
    private final PaymentRenderer paymentRenderer = new HtmlRenderer();

    private String name;
    private List<Visit> visits = new ArrayList<>();

    public Client(String name) {
        this.name = name;
    }

    public void addVisit(Visit visit) {
        visits.add(visit);
    }

    public String getReceipt() {
        TotalPayment totalPayment = getTotalPayment();
        String htmlTable = paymentRenderer.render(totalPayment);

        return htmlTable;
    }

    private TotalPayment getTotalPayment() {
        double totalPrice = 0;
        int loyaltyPoints = 0;
        List<FacilityPayment> facilityPayments = new ArrayList<>();

        for (Visit visit : this.visits) {
            totalPrice += visit.countPrice();
            loyaltyPoints += visit.countPoints();

            FacilityPayment facilityPayment = new FacilityPayment(visit.getFacility().getName(), visit.countPrice(), visit.countPoints());
            facilityPayments.add(facilityPayment);
        }

        return new TotalPayment(name, totalPrice, loyaltyPoints, facilityPayments);
    }

}
