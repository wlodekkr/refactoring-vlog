package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.Accountancy;
import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;
import pl.refactoring.vlog04.todo.accountancy.VolunteerAccountancy;

class VolunteerPerson extends Person {
    Accountancy accountancy = new VolunteerAccountancy();

    VolunteerPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        super(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
    }

    @Override
    public int getBaseSalary(){
        return accountancy.getBaseSalary(this);
    }

    @Override
    public int getNighttimeSupplement() {
        return accountancy.getNighttimeSupplement(this);
    }

    @Override
    public int getOvertimeSalary(){
        return accountancy.getOvertimeSalary(this);
    }

    @Override
    public int getSickLeaveSalary(){
        return accountancy.getSickLeaveSalary(this);
    }

    @Override
    public int getBonusCoins(){
        return accountancy.getBonusCoins(this);
    }

}
