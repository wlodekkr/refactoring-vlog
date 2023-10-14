package pl.refactoring.vlog04.todo;

import pl.refactoring.vlog04.todo.WorkRecordsSummary;

public interface Accountancy {
    int getBaseSalary(WorkRecordsSummary workRecordsSummary);

    int getNighttimeSupplement(WorkRecordsSummary workRecordsSummary);

    int getOvertimeSalary(WorkRecordsSummary workRecordsSummary);

    int getSickLeaveSalary(WorkRecordsSummary workRecordsSummary);

    int getBonusCoins(WorkRecordsSummary workRecordsSummary);
}
