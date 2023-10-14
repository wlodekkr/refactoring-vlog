package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;

class VolunteerPerson extends Person {
    VolunteerAccountancy volunteerAccountancy = new VolunteerAccountancy();

    VolunteerPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        super(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
    }

    @Override
    public int getBaseSalary(){
        return volunteerAccountancy.getBaseSalary(this);
    }

    @Override
    public int getNighttimeSupplement() {
        return volunteerAccountancy.getNighttimeSupplement(this);
    }

    @Override
    public int getOvertimeSalary(){
        return volunteerAccountancy.getOvertimeSalary(this);
    }

    @Override
    public int getSickLeaveSalary(){
        return volunteerAccountancy.getSickLeaveSalary(this);
    }

    @Override
    public int getBonusCoins(){
        return volunteerAccountancy.getBonusCoins(this);
    }

}
