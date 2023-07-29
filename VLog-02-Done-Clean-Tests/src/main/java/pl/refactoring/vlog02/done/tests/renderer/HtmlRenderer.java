package pl.refactoring.vlog02.done.tests.renderer;

import pl.refactoring.vlog02.done.tests.PaymentRenderer;
import pl.refactoring.vlog02.done.tests.TotalPayment;
import pl.refactoring.vlog02.done.tests.FacilityPayment;

public class HtmlRenderer implements PaymentRenderer {
    public HtmlRenderer() {
    }

    @Override
    public String render(TotalPayment totalPayment) {
        StringBuilder result = new StringBuilder("<table>" + "\n");

        result.append("<th>" + "\n");
        result.append("  <td colspan='3'>Receipt for customer : ").append(totalPayment.getClientName()).append("</td>").append("\n");
        result.append("</th>" + "\n");

        result.append("<th>" + "\n");
        result.append("  <td>Facility</td>" + "\n");
        result.append("  <td>Price</td>" + "\n");
        result.append("  <td>Points</td>" + "\n");
        result.append("</th>" + "\n");

        for (FacilityPayment facilityPayment : totalPayment.getFacilityPayments()) {
            result.append("<tr>" + "\n");
            result.append("  <td>").append(facilityPayment.getFacilityName()).append("</td>").append("\n");
            result.append("  <td>").append(facilityPayment.getFacilityPrice()).append("</td>").append("\n");
            result.append("  <td>").append(facilityPayment.getFacilityPoints()).append("</td>").append("\n");
            result.append("</tr>" + "\n");
        }

        //add footer lines
        result.append("<tr class='summary'>" + "\n");
        result.append("  <td>Total</td>" + "\n");
        result.append("  <td>").append(totalPayment.getTotalPrice()).append("</td>").append("\n");
        result.append("  <td>").append(totalPayment.getLoyaltyPoints()).append("</td>").append("\n");
        result.append("</tr>" + "\n");

        result.append("</table>" + "\n");

        return result.toString();
    }
}