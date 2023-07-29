package pl.refactoring.vlog02.todo;

import org.junit.jupiter.api.Test;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

/**
 * Sources provided under freeware licence
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SteamBathVisitTest {
    /*
     * 5.0 EUR - for each hours in Jacuzzi (very exclusive, only a few seats...)
     */
    @Test
    public void oneHour_PayForEach() {
        // Given
        Facility beFitGym = new Facility("Be Fit Jacuzzi - Washington Street", Facility.STEAM_BATH);
        Visit visit = new Visit(beFitGym, 1);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Jacuzzi - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("5.0");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("150");
    }

    @Test
    public void twoHours_PayForEach() {
        // Given
        Facility beFitGym = new Facility("Be Fit Jacuzzi - Washington Street", Facility.STEAM_BATH);
        Visit visit = new Visit(beFitGym, 2);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Jacuzzi - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("10.0");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("300");
    }

    @Test
    public void threeHours_PayForEach() {
        // Given
        Facility beFitGym = new Facility("Be Fit Jacuzzi - Washington Street", Facility.STEAM_BATH);
        Visit visit = new Visit(beFitGym, 3);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Jacuzzi - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("15.0");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("450");
    }
}
