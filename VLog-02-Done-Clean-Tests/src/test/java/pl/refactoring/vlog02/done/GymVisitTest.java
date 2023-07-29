package pl.refactoring.vlog02.done;

import org.junit.jupiter.api.Test;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GymVisitTest {

    /*
     * 4.00 EUR - for first two hours
     * 0.50 EUR - for each subsequent started hour
     */

    private String newPaymentFor(int type, int hours) {
        Facility beFitGym = new Facility("Be Fit Gym - Washington Street", type);
        Visit visit = new Visit(beFitGym, hours);
        Client client = new Client("Mike");

        client.addVisit(visit);
        return client.getReceipt();
    }

    @Test
    public void oneHour_payEntryFee() {
        // When
        String payment = newPaymentFor(Facility.GYM, 1);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Gym - Washington Street")
                .hasPrice("4.0")
                .hasPoints("100");
    }

    @Test
    public void twoHours_isOnly_payEntryFee() {
        // When
        String payment = newPaymentFor(Facility.GYM, 2);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Gym - Washington Street")
                .hasPrice("4.0")
                .hasPoints("100");
    }

    @Test
    public void threeHours_payEntryFee_And_oneHour() {
        // When
        String payment = newPaymentFor(Facility.GYM, 3);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Gym - Washington Street")
                .hasPrice("4.5")
                .hasPoints("100");
    }

    @Test
    public void fourHours_payEntryFee_And_twoHours() {
        // When
        String payment = newPaymentFor(Facility.GYM, 4);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Gym - Washington Street")
                .hasPrice("5.0")
                .hasPoints("100");
    }
}
