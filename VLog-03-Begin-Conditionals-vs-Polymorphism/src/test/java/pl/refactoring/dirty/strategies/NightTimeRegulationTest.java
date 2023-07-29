package pl.refactoring.dirty.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static pl.refactoring.dirty.strategies.NightShiftConfigAssertion.assertConfig;

class NightTimeRegulationTest {
    @Test
    void nighttime_8_59_PM() {
        assertThatThrownBy(() ->new NightTimeRegulation(23,1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nighttime_9_00_PM() {
        assertConfig(new NightTimeRegulation(22,0))
                .hasEndHour(6)
                .hasEndMinute(0);
    }

    @Test
    void nighttime_10_59_PM() {
        assertConfig(new NightTimeRegulation(22,59))
                .hasEndHour(6)
                .hasEndMinute(59);
    }

    @Test
    void nighttime_11_00_PM() {
        assertConfig(new NightTimeRegulation(23,0))
                .hasEndHour(7)
                .hasEndMinute(0);
    }

    @Test
    void nighttime_11_01_PM() {
        assertThatThrownBy(() ->new NightTimeRegulation(23,1))
                .isInstanceOf(IllegalArgumentException.class);
    }


}