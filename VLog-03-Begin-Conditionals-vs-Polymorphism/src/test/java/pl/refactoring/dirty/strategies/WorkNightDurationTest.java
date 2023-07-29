package pl.refactoring.dirty.strategies;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.Instant;

import static pl.refactoring.dirty.strategies.PersonAssertion.assertPerson;
import static pl.refactoring.dirty.strategies.TestConstants.*;

public class WorkNightDurationTest {
    /**
     * Night hours are defined as 8 consecutive hours between 9PM and 7AM
     * Here we use : 11PM - 7AM
     *
     * Do consider part of shit as nighttime following conditions have to be met
     * - At least 3 hours or 25% of the shit-duration during nighttime
     * - Not more than 8 hours are considered as nighttime
     */

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void no_nighttime(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(MON, 7, 0);
        Instant end = instantOf(MON, 15, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(0)
                .hasNightMinutes(0);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void full_nighttime(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(MON, 23, 0);
        Instant end = instantOf(TUE, 7, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(8)
                .hasNightMinutes(8 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void ending_nighttime(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_21_5, 8);

        Instant begin = instantOf(MON, 15, 0);
        Instant end = instantOf(MON, 23, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(2)
                .hasNightMinutes(2 * 60);
    }


    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void beginning_nighttime_1(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_21_5, 8);

        Instant begin = instantOf(MON, 23, 0);
        Instant end = instantOf(TUE, 7, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(6)
                .hasNightMinutes(6 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void beginning_nighttime_2(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_23_7, 8);

        Instant begin = instantOf(TUE, 4, 0);
        Instant end = instantOf(TUE, 12, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(3)
                .hasNightMinutes(3 * 60);
    }

    @ParameterizedTest
    @EnumSource(CooperationType.class)
    public void embracing_nighttime(CooperationType type){
        Person person = new Person(1, "Adam", "Smith", type, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = instantOf(MON, 21, 0);
        Instant end = instantOf(TUE, 7, 0);

        person.registerTime(begin, end);

        assertPerson(person)
                .hasNightHours(8)
                .hasNightMinutes(8 * 60);
    }
}
