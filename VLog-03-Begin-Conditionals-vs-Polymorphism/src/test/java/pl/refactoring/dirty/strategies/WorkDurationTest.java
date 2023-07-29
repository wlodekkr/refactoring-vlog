package pl.refactoring.dirty.strategies;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Instant;

import static pl.refactoring.dirty.strategies.PersonAssertion.assertPerson;
import static pl.refactoring.dirty.strategies.TestConstants.*;

public class WorkDurationTest {
    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Morning(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(MON, 7, 0);
        Instant end = instantOf(MON, 15, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Night(){
        Person person = new Person(1, "Adam", "Smith", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(MON, 23, 0);
        Instant end = instantOf(TUE, 7, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Half_Afternoon_And_Night(){
        Person person = new Person(1, "Adam", "Smith", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(MON, 15, 0);
        Instant end = instantOf(MON, 23, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }
}
