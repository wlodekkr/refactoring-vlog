package pl.refactoring.vlog04.todo.people;

public class VolunteerAccountancy {
    int getBaseSalary(VolunteerPerson volunteerPerson) {
        return 0;
    }

    int getNighttimeSupplement(VolunteerPerson volunteerPerson) {
        int nightHours = volunteerPerson.getNightHours();

        if (nightHours < volunteerPerson.getShiftHoursDuration() / 4.0)
            return 0;

        return 0;
    }

    int getOvertimeSalary(VolunteerPerson volunteerPerson) {
        return 0;
    }

    int getSickLeaveSalary(VolunteerPerson volunteerPerson) {
        return 0;
    }

    int getBonusCoins(VolunteerPerson volunteerPerson) {
        return 3 * volunteerPerson.getAllHours();
    }
}
