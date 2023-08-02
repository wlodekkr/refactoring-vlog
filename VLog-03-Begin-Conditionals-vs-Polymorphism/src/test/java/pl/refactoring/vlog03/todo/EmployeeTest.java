package pl.refactoring.vlog03.todo;

import org.junit.jupiter.api.Test;

import java.time.Instant;

public class EmployeeTest {

    /**
     * Employee is paid 10USD per hour
     * Night hours supplement 2USD per hour
     * Overtime supplement : 50% at day and 100% more at nighttime (23:00 - 7:00)
     */

    @Test
    public void baseSalaryFor1Hour(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 7, 0);
        Instant end = TestConstants.instantOf(TestConstants.MON, 8, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBaseSalary(10);
    }

    @Test
    public void baseSalaryFor8Hours(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.MON, 7, 0);
        Instant end = TestConstants.instantOf(TestConstants.MON, 15, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBaseSalary(80);
    }

    @Test
    public void nighttimeSupplementFor1Hour(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.FRI, 15, 0);
        Instant end = TestConstants.instantOf(TestConstants.FRI, 23, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasNighttimeSupplement(0);
    }

    @Test
    public void nighttimeSupplementFor2Hours(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_21_5, 8);

        Instant begin = TestConstants.instantOf(TestConstants.SAT, 15, 0);
        Instant end = TestConstants.instantOf(TestConstants.SAT, 23, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasNighttimeSupplement(2 * 2);
    }

    @Test
    public void nighttimeSupplementFor8Hours(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.WED, 22, 0);
        Instant end = TestConstants.instantOf(TestConstants.THU, 6, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasNighttimeSupplement(8 * 2);
    }

    @Test
    public void bonusCoinsFor1Hour(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.FRI, 15, 0);
        Instant end = TestConstants.instantOf(TestConstants.FRI, 16, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBonusCoins(3);
    }

    @Test
    public void bonusCoinsFor2Hours(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_21_5, 8);

        Instant begin = TestConstants.instantOf(TestConstants.SAT, 15, 0);
        Instant end = TestConstants.instantOf(TestConstants.SAT, 17, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBonusCoins(5);
    }

    @Test
    public void bonusFor8Hours(){
        Person person = new Person(1, "Adam", "Employee", CooperationType.EMPLOYEE, NightTimeRegulation.NIGHT_SHIFT_22_6, 8);

        Instant begin = TestConstants.instantOf(TestConstants.WED, 22, 0);
        Instant end = TestConstants.instantOf(TestConstants.THU, 6, 0);

        person.registerTime(begin, end);

        PersonAssertion.assertPerson(person)
                .hasBonusCoins(20);
    }
}
