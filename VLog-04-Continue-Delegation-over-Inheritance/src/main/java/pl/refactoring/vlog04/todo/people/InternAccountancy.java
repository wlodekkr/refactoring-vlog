package pl.refactoring.vlog04.todo.people;

public class InternAccountancy {
    int getBaseSalary(InternPerson internPerson) {
        return 5 * internPerson.getAllHours();
    }

    int getNighttimeSupplement(InternPerson internPerson) {
        int nightHours = internPerson.getNightHours();

        if (nightHours < internPerson.getShiftHoursDuration() / 4.0)
            return 0;

        return 2 * nightHours;
    }

    int getOvertimeSalary(InternPerson internPerson) {
        return 0;
    }

    int getSickLeaveSalary(InternPerson internPerson) {
        return 0;
    }

    int getBonusCoins(InternPerson internPerson) {
        return 0;
    }
}
