package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;

class InternPerson extends Person {
    InternPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        super(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
    }

    @Override
    public int getBaseSalary(){
        return 5 * getAllHours();
    }

    @Override
    public int getNighttimeSupplement() {
        int nightHours = getNightHours();

        if (nightHours < shiftHoursDuration / 4.0)
            return 0;

        return 2 * nightHours;
    }

    @Override
    public int getOvertimeSalary(){
        return 0;
    }

    @Override
    public int getSickLeaveSalary(){
        return 0;
    }

    @Override
    public int getBonusCoins(){
        return 0;
    }
}
