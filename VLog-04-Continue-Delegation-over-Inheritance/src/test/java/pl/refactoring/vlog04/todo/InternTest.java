package pl.refactoring.vlog04.todo;

import org.junit.jupiter.api.Test;
import pl.refactoring.vlog04.todo.people.PersonFactory;

import java.time.Instant;

import static pl.refactoring.vlog04.todo.PersonAssertion.assertPerson;
import static pl.refactoring.vlog04.todo.TestConstants.*;
import static pl.refactoring.vlog04.todo.TestConstants.THU;

public class InternTest {
    /**
     * Intern employee is paid 5USD per hour
     * Night hours supplement 2USD per hour
     * Overtime not allowed
     */

    @Test
    public void baseSalaryFor1Hour(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(MON, 7, 0);
        Instant end = instantOf(MON, 8, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasBaseSalary(5);
    }

    @Test
    public void baseSalaryFor8Hours(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(MON, 7, 0);
        Instant end = instantOf(MON, 15, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasBaseSalary(8 * 5);
    }

    @Test
    public void nighttimeSupplementFor1Hour(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(FRI, 15, 0);
        Instant end = instantOf(FRI, 23, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNighttimeSupplement(0);
    }

    @Test
    public void nighttimeSupplementFor2Hours(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_21_5, 8);

        Instant begin = instantOf(SAT, 15, 0);
        Instant end = instantOf(SAT, 23, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNighttimeSupplement(2 * 2);
    }

    @Test
    public void nighttimeSupplementFor8Hours(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(WED, 22, 0);
        Instant end = instantOf(THU, 6, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNighttimeSupplement(8 * 2);
    }

    @Test
    public void bonusCoinsFor8Hours(){
        Person person = PersonFactory.createPerson(1, "Adam", "Intern", CooperationType.INTERN, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(WED, 22, 0);
        Instant end = instantOf(THU, 6, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasBonusCoins(0);
    }


}
