package pl.refactoring.vlog04.todo;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;
import pl.refactoring.vlog04.todo.accountancy.EmployeeAccountancy;
import pl.refactoring.vlog04.todo.accountancy.InternAccountancy;
import pl.refactoring.vlog04.todo.accountancy.VolunteerAccountancy;

public class PersonFactory {
    public static Person createPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        return switch (type){
            case EMPLOYEE -> new Person(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration, new EmployeeAccountancy());
            case INTERN -> new Person(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration, new InternAccountancy());
            case VOLUNTEER -> new Person(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration, new VolunteerAccountancy());
        };
    }
}
