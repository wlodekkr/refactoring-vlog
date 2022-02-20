package pl.refactoring.conditional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InternPayoutTest {
    public static Worker INTERN; //= new Worker("Mike", "Brown");

    // Must work at least 20 hours per month
    // Payout : if at least 20 hours weekly
    // Overtime : not considered

    @Test
    @Disabled
    void volunteerShouldGetNoBaseSalary() {
        WorkerPayout payout = new WorkerPayout(INTERN);

        assertThat(payout.getBaseSalary())
                .isEqualTo(200);
    }

    @Test
    @Disabled
    void volunteerShouldGetNoOvertimeBenefit() {
        WorkerPayout payout = new WorkerPayout(INTERN);

        assertThat(payout.getOvertimeRate(1))
                .isEqualTo(0);
    }
}