package pl.refactoring.conditional;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeePayoutTest {
    private static final Worker EMPLOYEE = new Worker("Stanley", "Williams", 3200, 160);


    @Test
    void employeeShouldGetBaseSalary() {
        WorkerPayout payout = new WorkerPayout(EMPLOYEE);

        assertThat(payout.getBaseSalary())
                .isEqualTo(3200);
    }

    @Test
    void employeeShouldGetNoOvertime_WhenAllHours_NotExceeding_BaseHours() {
        WorkerPayout payout = new WorkerPayout(EMPLOYEE);

        assertThat(payout.getOvertimeRate(1))
                .isEqualTo(0);
    }

    void employeeShouldGetOvertime_For_One_Exceeding_Hour() {
        WorkerPayout payout = new WorkerPayout(EMPLOYEE);

        assertThat(payout.getOvertimeRate(161))
                .isEqualTo(30);
    }

    void employeeShouldGetOvertime_For_Two_Exceeding_Hours() {
        WorkerPayout payout = new WorkerPayout(EMPLOYEE);

        assertThat(payout.getOvertimeRate(162))
                .isEqualTo(60);
    }
}