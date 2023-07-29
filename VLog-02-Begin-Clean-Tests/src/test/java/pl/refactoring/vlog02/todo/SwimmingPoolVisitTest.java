package pl.refactoring.vlog02.todo;

import org.junit.jupiter.api.Test;

import static org.xmlunit.assertj3.XmlAssert.assertThat;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class SwimmingPoolVisitTest {
   /*
    * 3.0 EUR - for first hour
    * 1.5 USD - for each subsequent hour
    */

    @Test
    public void oneHour_payEntryFee() {
        // Given
        Facility beFitGym = new Facility("Be Fit Swimming Pool - Washington Street", Facility.SWIMMING_POOL);
        Visit visit = new Visit(beFitGym, 1);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Swimming Pool - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("3.0");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }

    @Test
    public void twoHours_payEntryFee_And_oneHour() {
        // Given
        Facility beFitGym = new Facility("Be Fit Swimming Pool - Washington Street", Facility.SWIMMING_POOL);
        Visit visit = new Visit(beFitGym, 2);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Swimming Pool - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("4.5");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }

    @Test
    public void threeHours_payEntryFee_And_twoHours() {
        // Given
        Facility beFitGym = new Facility("Be Fit Swimming Pool - Washington Street", Facility.SWIMMING_POOL);
        Visit visit = new Visit(beFitGym, 3);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Swimming Pool - Washington Street");
        assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("6.0");
        assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }
}
