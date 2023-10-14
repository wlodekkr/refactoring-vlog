package pl.refactoring.vlog04.todo;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonAssertion extends AbstractAssert<PersonAssertion, Person> {

    private PersonAssertion(Person person) {
        super(person, PersonAssertion.class);
    }

    public static PersonAssertion assertPerson(Person workRecordsSummary) {
        return new PersonAssertion(workRecordsSummary);
    }

    PersonAssertion hasAllHours(int expected) {
        int actualAllHours = actual.getAllHours();

        if (!Objects.areEqual(actualAllHours, expected)) {
            failWithMessage("All Hours should be %d, but was %d", expected, actualAllHours);
        }

        return this;
    }

    PersonAssertion hasNightHours(int expected) {
        int nightHours = actual.getNightHours();

        if (!Objects.areEqual(nightHours, expected)) {
            failWithMessage("Night Hours should be %d, but was %d", expected, nightHours);
        }

        return this;
    }

    PersonAssertion hasAllMinutes(int expected) {
        int allMinutes = actual.getAllMinutes();

        if (!Objects.areEqual(allMinutes, expected)) {
            failWithMessage("All Minutes should be %d, but was %d", expected, allMinutes);
        }

        return this;
    }

    PersonAssertion hasNightMinutes(int expected) {
        int nightMinutes = actual.getNightMinutes();

        if (!Objects.areEqual(nightMinutes, expected)) {
            failWithMessage("Night Minutes should be %d, but was %d", expected, nightMinutes);
        }

        return this;
    }

    public PersonAssertion hasBaseSalary(int expected) {
        int baseSalary = actual.getBaseSalary();

        if (!Objects.areEqual(baseSalary, expected)) {
            failWithMessage("Base Salary should be be %d, but was %d", expected, baseSalary);
        }

        return this;
    }

    public PersonAssertion hasNighttimeSupplement(int expected) {
        int supplement = actual.getNighttimeSupplement();

        if (!Objects.areEqual(supplement, expected)) {
            failWithMessage("Nighttime Supplement should be %d, but was %d", expected, supplement);
        }

        return this;
    }

    public PersonAssertion hasBonusCoins(int expected) {
        int bonusCoins = actual.getBonusCoins();

        if (!Objects.areEqual(bonusCoins, expected)) {
            failWithMessage("Bonus Coins should be %d, but was %d", expected, bonusCoins);
        }

        return this;
    }
}
