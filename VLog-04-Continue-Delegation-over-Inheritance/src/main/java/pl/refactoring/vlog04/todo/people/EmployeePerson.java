package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;

class EmployeePerson extends Person {
    EmployeeAccountancy employeeAccountancy = new EmployeeAccountancy();

    EmployeePerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        super(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
    }

    @Override
    public int getBaseSalary(){
        return employeeAccountancy.getBaseSalary(this);
    }

    @Override
    public int getNighttimeSupplement() {
        return employeeAccountancy.getNighttimeSupplement(this);
    }

    @Override
    public int getOvertimeSalary(){
        return employeeAccountancy.getOvertimeSalary(this);
    }

    @Override
    public int getSickLeaveSalary(){
        return employeeAccountancy.extractedGetSickLeaveSalary(this);
    }

    @Override
    public int getBonusCoins(){
        return employeeAccountancy.getBonusCoins(this);
    }

}
