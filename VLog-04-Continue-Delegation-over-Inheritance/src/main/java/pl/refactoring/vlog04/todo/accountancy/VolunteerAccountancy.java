package pl.refactoring.vlog04.todo.accountancy;

import pl.refactoring.vlog04.todo.WorkRecordsSummary;
import pl.refactoring.vlog04.todo.Accountancy;

public class VolunteerAccountancy implements Accountancy {
    public int getBaseSalary(WorkRecordsSummary workRecordsSummary) {
        return 0;
    }

    public int getNighttimeSupplement(WorkRecordsSummary workRecordsSummary) {
        int nightHours = workRecordsSummary.getNightHours();

        if (nightHours < workRecordsSummary.getShiftHoursDuration() / 4.0)
            return 0;

        return 0;
    }

    public int getOvertimeSalary(WorkRecordsSummary workRecordsSummary) {
        return 0;
    }

    public int getSickLeaveSalary(WorkRecordsSummary workRecordsSummary) {
        return 0;
    }

    public int getBonusCoins(WorkRecordsSummary workRecordsSummary) {
        return 3 * workRecordsSummary.getAllHours();
    }
}