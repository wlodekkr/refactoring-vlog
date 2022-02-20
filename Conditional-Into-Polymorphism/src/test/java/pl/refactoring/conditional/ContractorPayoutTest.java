package pl.refactoring.conditional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContractorPayoutTest {

    private static final Worker CONTRACTOR = new Worker("John", "Smith", 30);

    @Test
    void contractorShouldGetNoBaseSalary() {
        WorkerPayout payout = new WorkerPayout(CONTRACTOR);

        assertThat(payout.getBaseSalary())
                .isEqualTo(0);
    }

    @Test
    void contractorShouldGet_20EUR_per_1Hour() {
        WorkerPayout payout = new WorkerPayout(CONTRACTOR);

        assertThat(payout.getOvertimeRate(1))
                .isEqualTo(30);
    }

    @Test
    void contractorShouldGet_40EUR_per_2Hours() {
        WorkerPayout payout = new WorkerPayout(CONTRACTOR);

        assertThat(payout.getOvertimeRate(2))
                .isEqualTo(60);
    }
}