package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;

class InternPerson extends Person {
    InternAccountancy internAccountancy = new InternAccountancy();

    InternPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        super(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
    }

    @Override
    public int getBaseSalary(){
        return internAccountancy.getBaseSalary(this);
    }

    @Override
    public int getNighttimeSupplement() {
        return internAccountancy.getNightimeSupplement(this);
    }

    @Override
    public int getOvertimeSalary(){
        return internAccountancy.getOvertimeSalary(this);
    }

    @Override
    public int getSickLeaveSalary(){
        return internAccountancy.getSickLeaveSalary(this);
    }

    @Override
    public int getBonusCoins(){
        return internAccountancy.getBonusCoins(this);
    }

}
