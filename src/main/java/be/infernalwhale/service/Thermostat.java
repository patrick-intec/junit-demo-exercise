package be.infernalwhale.service;

public class Thermostat {
    private Heater heater;
    private AtmosphericEvaluator atmosphericEvaluator;
    private Double triggerTemperature;

    public Thermostat(Heater h, AtmosphericEvaluator tm) {
        this.heater = h;
        this.atmosphericEvaluator = tm;
    }

    public void setTriggerTemperature(Double temp) {
        this.triggerTemperature = temp;
    }

    public void checkTemp() {
        if (this.triggerTemperature == null) setIndicatorLed(false);     // This will happen when Thermostat is broken
        if ( atmosphericEvaluator.getTemperature() < this.triggerTemperature ) return;
        else this.heater.turnOn();
    }

    private void setIndicatorLed(boolean onOrOff) {

    }


    /**
     * we testen of de methode/klasse werkt zoals verwacht voor ALLE scenarios
     *
     * 4 scenarios:
     * 1. Current temp is lower then trigger >> Heater should turn on
     * Current temp: 10, Trigger: 15
     * Current temp: 14.99, Trigger: 15.0
     * 2. Current temp is equal to trigger >> Heater should stay on until it goes higher? Maybe no action? Turn off...
     * Correct answer: I don't know... Who does know??? The client (product owner) knows...
     * 3. Current temp is higher then trigger >> Heater should turn off
     * 4. NULL values... >> In this situation it looks like a non-option...
     */

    /**
     * Coin flip... what are all possible outcomes?
     * 1. Head - Kop
     * 2. Tail - Munt
     * 3. On it's side? What's the chance of this? 1/1.000.000.000.000
     * The important thing is: it's a non-zero chance...
     * Do we want to take this into account?
     * Emrah says: ignore this shit... de kans is zo klein en het leven is te kort to worry about a 1 in a trillion chance...
     * Sahar says: no no no no... we can't ignore it, because it could make our application crash...
     *
     * it kinda depends...
     * situation 1: (this situation is ABSOLUTELY FICTIONAL)
     * Let's say somebodies life depends on the coin flip... Would it be worth then to write a test for situation 3??
     *
     * situation 2: The life is of somebody you don't like... Would you write a test then?
     */
}
