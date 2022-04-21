package be.infernalwhale.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ThermostatTest {
    // What are the things we want to test about the Thermostat??

    // 1. Test if temperature is higher or equal then the trigger, turn the heater off (call turnOff method)
    // 2. Test if temperature is lower then the trigger, turn the heater on (call turnOn method)

    @Test
    void triggerTest1() {
        final BooleanWrapper methodIsCalled = new BooleanWrapper(false);

        Heater h = new Heater() {
            @Override
            public void turnOn() {
                methodIsCalled.setValue(true);
            }
        };

        Thermometer tm = new Thermometer() {
            @Override
            public int getTemperature() {
                return 10;
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

        Thermometer tm = new Thermometer() {
            @Override
            public int getTemperature() {
                return 0;
            }
        };

    }
}
