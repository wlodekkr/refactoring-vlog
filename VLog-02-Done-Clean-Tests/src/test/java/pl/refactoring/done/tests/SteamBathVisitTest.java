package pl.refactoring.done.tests;

import org.junit.jupiter.api.Test;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SteamBathVisitTest {
    /*
     * 5.0 EUR - for each hours in Jacuzzi (very exclusive, only a few seats...)
     */
    private String newPaymentFor(int type, int hours) {
        Facility beFitGym = new Facility("Be Fit Jacuzzi - Washington Street", type);
        Visit visit = new Visit(beFitGym, hours);
        Client client = new Client("Mike");

        client.addVisit(visit);
        return client.getReceipt();
    }

    @Test
    public void oneHour_PayForEach() {
        // When
        String payment = newPaymentFor(Facility.STEAM_BATH, 1);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Jacuzzi - Washington Street")
                .hasPrice("5.0")
                .hasPoints("150");
    }

    @Test
    public void twoHours_PayForEach() {
        // When
        String payment = newPaymentFor(Facility.STEAM_BATH, 2);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Jacuzzi - Washington Street")
                .hasPrice("10.0")
                .hasPoints("300");
    }

    @Test
    public void threeHours_PayForEach() {
        // When
        String payment = newPaymentFor(Facility.STEAM_BATH, 3);

        // Then
        FacilityAssertion.assertThat(payment)
                .hasName("Be Fit Jacuzzi - Washington Street")
                .hasPrice("15.0")
                .hasPoints("450");
    }
}
