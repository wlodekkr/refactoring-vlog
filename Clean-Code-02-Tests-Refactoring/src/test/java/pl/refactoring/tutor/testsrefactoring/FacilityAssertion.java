package pl.refactoring.tutor.testsrefactoring;

import org.xmlunit.assertj3.XmlAssert;

public class FacilityAssertion {
    private String payment;

    private FacilityAssertion(String payment) {
        this.payment = payment;
    }

    public static FacilityAssertion assertThat(String payment) {
        return new FacilityAssertion(payment);
    }

    FacilityAssertion hasPoints(String facilityPoints) {
        XmlAssert.assertThat(this.payment).valueByXPath("/table/tr[1]/td[3]").isEqualTo(facilityPoints);
        return this;
    }

    FacilityAssertion hasPrice(String facilityPrice) {
        XmlAssert.assertThat(this.payment).valueByXPath("/table/tr[1]/td[2]").isEqualTo(facilityPrice);
        return this;
    }

    FacilityAssertion hasName(String facilityName) {
        XmlAssert.assertThat(this.payment).valueByXPath("/table/tr[1]/td[1]").isEqualTo(facilityName);
        return this;
    }
}