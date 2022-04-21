package be.infernalwhale.service;

public class Thermostat {
    private Heater heater;
    private Thermometer thermometer;
    private int triggerTemperature;

    public Thermostat(Heater h, Thermometer tm) {
        this.heater = h;
        this.thermometer = tm;
    }

    public void setTriggerTemperature(int temp) {
        this.triggerTemperature = temp;
    }

    public void checkTemp() {
        if ( thermometer.getTemperature() < this.triggerTemperature ) return;
        else this.heater.turnOn();
    }
}
