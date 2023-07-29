package pl.refactoring.dirty.strategies;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static pl.refactoring.dirty.strategies.PersonAssertion.assertPerson;
import static pl.refactoring.dirty.strategies.TestConstants.*;
import static pl.refactoring.dirty.strategies.TestConstants.THU;

public class VolunteerTest {
    /**
     * Volunteer is working for free, but needs to register their time spent at work as well
     */

    @Test
    public void noBaseSalary(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(MON, 7, 0);
        Instant end = instantOf(MON, 15, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasBaseSalary(0);
    }

    @Test
    public void noNighttimeSupplement(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(WED, 22, 0);
        Instant end = instantOf(THU, 6, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNighttimeSupplement(0);
    }

    @Test
    public void bonusCoins(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(WED, 22, 0);
        Instant end = instantOf(THU, 6, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasBonusCoins(8 * 3);
    }
}
