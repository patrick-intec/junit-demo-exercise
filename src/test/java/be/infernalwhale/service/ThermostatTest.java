package be.infernalwhale.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ThermostatTest {
    // What are the things we want to test about the Thermostat??

    // 1. Test if temperature is higher or equal then the trigger, turn the heater off (call turnOff method)
    // 2. Test if temperature is lower then the trigger, turn the heater on (call turnOn method)

    // 0, 1, 2, 3, 4, 5, 9,
    // ParameterizedTests

    @Mock
    AtmosphericEvaluator evaluator;

    @BeforeEach
    void init() {
        System.out.println("Before Each method");
    }

    @ParameterizedTest
    @MethodSource("stringSupplier")
    void paramTestWithMethodSource(String input) {
        System.out.println(input);
    }

    private static List<String> stringSupplier() {
        return List.of("Hello", "World");
    }


    @Test
    void mockitoExample() {
        when(evaluator.getTemperature()).thenReturn(42);
        when(evaluator.getHumidity()).thenThrow(new NumberFormatException());

        System.out.println(evaluator.getTemperature());
        System.out.println(evaluator.getHumidity());
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 22, 23, 24, 25, Integer.MAX_VALUE})
    void paramTest_HeaterShouldTurnOff(Integer inputTemp) {
        final BooleanWrapper methodIsCalled = new BooleanWrapper(false);

        when(evaluator.getTemperature()).thenReturn(inputTemp);

        // Mock-ito
        // Library which makes creating mock objects a lot easier...

        Heater h = new Heater() { // Heater-mock
            @Override
            public void turnOn() {
                methodIsCalled.setValue(true);
            }
        };

        Thermostat thermostat = new Thermostat(h, evaluator);
        thermostat.setTriggerTemperature(12.0);
        thermostat.checkTemp();

        assertTrue(methodIsCalled.isValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 10})
    void paramTest_HeaterShouldTurnOn(Integer inputTemp) {
        final BooleanWrapper methodIsCalled = new BooleanWrapper(false);

        Heater h = new Heater() {
            @Override
            public void turnOn() {
                methodIsCalled.setValue(true);
            }
        };

        AtmosphericEvaluator tm = new AtmosphericEvaluator() {
            @Override
            public int getTemperature() {
                return inputTemp;
            }

            @Override
            public int getHumidity() {
                return 0;
            }

            @Override
            public int getAirPressure() {
                return 0;
            }

            @Override
            public int getCO2Levels() {
                return 0;
            }

            @Override
            public int getO2Levels() {
                return 0;
            }
        };

        Thermostat thermostat = new Thermostat(h, tm);
        thermostat.setTriggerTemperature(12.0);
        thermostat.checkTemp();

        assertTrue(methodIsCalled.isValue());
    }


    @Test
    void triggerTest1() {
        final BooleanWrapper methodIsCalled = new BooleanWrapper(false);

        // mock
        // spy

        Heater h = new Heater() {
            @Override
            public void turnOn() {
                methodIsCalled.setValue(true);
            }
        };

        AtmosphericEvaluator tm = new AtmosphericEvaluator() {
            @Override
            public int getTemperature() {
                return 10;
            }

            @Override
            public int getHumidity() {
                return 0;
            }

            @Override
            public int getAirPressure() {
                return 0;
            }

            @Override
            public int getCO2Levels() {
                return 0;
            }

            @Override
            public int getO2Levels() {
                return 0;
            }
        };

        Thermostat thermostat = new Thermostat(h, tm);

        assertTrue(methodIsCalled.isValue());
    }


    @Test
    void triggerTest2() {
        Heater h = new Heater() {
            @Override
            public void turnOn() {

            }
        };

        AtmosphericEvaluator tm = new AtmosphericEvaluator() {
            @Override
            public int getTemperature() {
                return 0;
            }

            @Override
            public int getHumidity() {
                return 0;
            }

            @Override
            public int getAirPressure() {
                return 0;
            }

            @Override
            public int getCO2Levels() {
                return 0;
            }

            @Override
            public int getO2Levels() {
                return 0;
            }
        };

    }
}
