package pl.refactoring.vlog04.todo.accountancy;

import pl.refactoring.vlog04.todo.WorkRecordsSummary;
import pl.refactoring.vlog04.todo.Accountancy;

public class EmployeeAccountancy implements Accountancy {
    @Override
    public int getBaseSalary(WorkRecordsSummary workRecordsSummary) {
        return 10 * workRecordsSummary.getAllHours();
    }

    @Override
    public int getNighttimeSupplement(WorkRecordsSummary workRecordsSummary) {
        int nightHours = workRecordsSummary.getNightHours();

        if (nightHours < workRecordsSummary.getShiftHoursDuration() / 4.0)
            return 0;

        return 2 * nightHours;
    }

    @Override
    public int getOvertimeSalary(WorkRecordsSummary workRecordsSummary) {
        return 0;
    }

    @Override
    public int getSickLeaveSalary(WorkRecordsSummary workRecordsSummary) {
        return 0;
    }

    @Override
    public int getBonusCoins(WorkRecordsSummary workRecordsSummary) {
        return (int) Math.round(0.25 * getBaseSalary(workRecordsSummary));
    }
}
