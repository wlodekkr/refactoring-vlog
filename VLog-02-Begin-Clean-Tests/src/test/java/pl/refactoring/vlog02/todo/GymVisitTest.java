package pl.refactoring.vlog02.todo;

import org.junit.jupiter.api.Test;
import org.xmlunit.assertj3.XmlAssert;

/**
 * Sources provided under artistic license
 * Wlodek Krakowski - www.refactoring.pl
 */
public class GymVisitTest {

    /*
     * 4.00 EUR - for first two hours
     * 0.50 EUR - for each subsequent started hour
     */

    @Test
    public void oneHour_payEntryFee() {
        // Given
        Facility beFitGym = new Facility("Be Fit Gym - Washington Street", Facility.GYM);
        Visit visit = new Visit(beFitGym, 1);
        Client client = new Client("Mike");

        // When
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Gym - Washington Street");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("4.0");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }

    @Test
    public void twoHours_isOnly_payEntryFee() {
        Facility beFitGym = new Facility("Be Fit Gym - Washington Street", Facility.GYM);
        Visit visit = new Visit(beFitGym, 2);
        Client client = new Client("Mike");

        // when
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Gym - Washington Street");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("4.0");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }

    @Test
    public void threeHours_payEntryFee_And_oneHour() {
        Facility beFitGym = new Facility("Be Fit Gym - Washington Street", Facility.GYM);
        Visit visit = new Visit(beFitGym, 3);
        Client client = new Client("Mike");

        // when
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Gym - Washington Street");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("4.5");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }

    @Test
    public void fourHours_payEntryFee_And_twoHours() {
        Facility beFitGym = new Facility("Be Fit Gym - Washington Street", Facility.GYM);
        Visit visit = new Visit(beFitGym, 4);
        Client client = new Client("Mike");

        // when
        client.addVisit(visit);
        String payment = client.getReceipt();

        // Then
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo("Be Fit Gym - Washington Street");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo("5.0");
        XmlAssert.assertThat(payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo("100");
    }
}
