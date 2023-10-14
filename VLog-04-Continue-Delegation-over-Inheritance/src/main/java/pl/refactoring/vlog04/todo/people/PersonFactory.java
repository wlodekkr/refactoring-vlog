package pl.refactoring.vlog04.todo.people;

import pl.refactoring.vlog04.todo.CooperationType;
import pl.refactoring.vlog04.todo.NightTimeRegulation;
import pl.refactoring.vlog04.todo.Person;

public class PersonFactory {
    public static Person createPerson(int id, String firstName, String lastName, CooperationType type, NightTimeRegulation nightTimeRegulation, int shiftHoursDuration) {
        return switch (type){
            case EMPLOYEE -> new EmployeePerson(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
            case INTERN -> new InternPerson(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
            case VOLUNTEER -> new VolunteerPerson(id, firstName, lastName, type, nightTimeRegulation, shiftHoursDuration);
        };
    }
}
