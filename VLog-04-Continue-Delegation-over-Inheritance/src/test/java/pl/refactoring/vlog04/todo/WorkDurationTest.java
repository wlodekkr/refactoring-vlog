package pl.refactoring.vlog04.todo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.refactoring.vlog04.todo.people.PersonFactory;

import java.time.Instant;

public class WorkDurationTest {
    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Morning(CooperationType type){
        Person person = PersonFactory.createPerson(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 7, 0);
        Instant end = TestConstants.instantOf(TestConstants.MON, 15, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Night(){
        Person person = PersonFactory.createPerson(1, "Adam", "Smith", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 23, 0);
        Instant end = TestConstants.instantOf(TestConstants.TUE, 7, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void monday_8Hours_Half_Afternoon_And_Night(){
        Person person = PersonFactory.createPerson(1, "Adam", "Smith", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 15, 0);
        Instant end = TestConstants.instantOf(TestConstants.MON, 23, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasAllHours(8)
                .hasAllMinutes(8 * 60);
    }
}
