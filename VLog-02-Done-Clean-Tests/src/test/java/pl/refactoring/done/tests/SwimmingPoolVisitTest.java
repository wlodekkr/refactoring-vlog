package pl.refactoring.done.tests;

import org.junit.jupiter.api.Test;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SwimmingPoolVisitTest {
   /*
    * 3.0 EUR - for first hour
    * 1.5 USD - for each subsequent hour
    */

    private String newPaymentFor(int type, int hours) {
        Facility beFitGym = new Facility("Be Fit Swimming Pool - Washington Street", type);
        Visit visit = new Visit(beFitGym, hours);
        Client client = new Client("Mike");

        client.addVisit(visit);
        return client.getReceipt();
    }

    @Test
    public void oneHour_payEntryFee() {
        // When
        String payment = newPaymentFor(Facility.SWIMMING_POOL, 1);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Swimming Pool - Washington Street")
                .hasPrice("3.0")
                .hasPoints("100");
    }

    @Test
    public void twoHours_payEntryFee_And_oneHour() {
        // When
        String payment = newPaymentFor(Facility.SWIMMING_POOL, 2);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Swimming Pool - Washington Street")
                .hasPrice("4.5")
                .hasPoints("100");
    }

    @Test
    public void threeHours_payEntryFee_And_twoHours() {
        // When
        String payment = newPaymentFor(Facility.SWIMMING_POOL, 3);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Swimming Pool - Washington Street")
                .hasPrice("6.0")
                .hasPoints("100");
    }
}
