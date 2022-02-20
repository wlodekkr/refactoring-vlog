package pl.refactoring.conditional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VolunteerPayoutTest {
    public static final Worker VOLUNTEER = new Worker("Mike", "Brown");

    @Test
    void volunteerShouldGetNoBaseSalary() {
        WorkerPayout payout = new WorkerPayout(VOLUNTEER);

        assertThat(payout.getBaseSalary())
                .isEqualTo(0);
    }

    @Test
    void volunteerShouldGetNoOvertimeBenefit() {
        WorkerPayout payout = new WorkerPayout(VOLUNTEER);

        assertThat(payout.getOvertimeRate(1))
                .isEqualTo(0);
    }
}