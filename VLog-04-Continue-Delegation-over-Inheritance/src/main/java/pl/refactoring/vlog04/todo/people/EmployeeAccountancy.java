package pl.refactoring.vlog04.todo.people;

public class EmployeeAccountancy {
    int getBaseSalary(EmployeePerson employeePerson) {
        return 10 * employeePerson.getAllHours();
    }

    int getNighttimeSupplement(EmployeePerson employeePerson) {
        int nightHours = employeePerson.getNightHours();

        if (nightHours < employeePerson.getShiftHoursDuration() / 4.0)
            return 0;

        return 2 * nightHours;
    }

    int getOvertimeSalary(EmployeePerson employeePerson) {
        return 0;
    }

    int extractedGetSickLeaveSalary(EmployeePerson employeePerson) {
        return 0;
    }

    int getBonusCoins(EmployeePerson employeePerson) {
        return (int) Math.round(0.25 * employeePerson.getBaseSalary());
    }
}
