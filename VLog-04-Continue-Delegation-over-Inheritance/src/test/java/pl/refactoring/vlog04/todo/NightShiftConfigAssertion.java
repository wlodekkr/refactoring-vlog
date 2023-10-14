package pl.refactoring.vlog04.todo;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

public class NightShiftConfigAssertion extends AbstractAssert<NightShiftConfigAssertion, NightTimeRegulation> {
    private NightShiftConfigAssertion(NightTimeRegulation config) {
        super(config, NightShiftConfigAssertion.class);
    }

    public static NightShiftConfigAssertion assertConfig(NightTimeRegulation config) {
        return new NightShiftConfigAssertion(config);
    }

    public NightShiftConfigAssertion hasEndHour(int expected){
        int endHour = actual.endHourOfDay();

        if (!Objects.areEqual(endHour, expected)) {
            failWithMessage("End Hour should be %d, but was %d", expected, endHour);
        }

        return this;
    }

    public NightShiftConfigAssertion hasEndMinute(int expected){
        int endMinute = actual.endMinute();

        if (!Objects.areEqual(endMinute, expected)) {
            failWithMessage("End Minute should be %d, but was %d", expected, endMinute);
        }

        return this;
    }
}
