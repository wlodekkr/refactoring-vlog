package pl.refactoring.vlog03.todo;

import org.junit.jupiter.api.Test;

import java.time.Instant;

public class VolunteerTest {
    /**
     * Volunteer is working for free, but needs to register their time spent at work as well
     */

    @Test
    public void noBaseSalary(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 7, 0);
        Instant end = TestConstants.instantOf(TestConstants.MON, 15, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBaseSalary(0);
    }

    @Test
    public void noNighttimeSupplement(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.WED, 22, 0);
        Instant end = TestConstants.instantOf(TestConstants.THU, 6, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasNighttimeSupplement(0);
    }

    @Test
    public void bonusCoins(){
        Person person = new Person(1, "Vadym", "Volunteer", CooperationType.VOLUNTEER, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.WED, 22, 0);
        Instant end = TestConstants.instantOf(TestConstants.THU, 6, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBonusCoins(8 * 3);
    }
}
