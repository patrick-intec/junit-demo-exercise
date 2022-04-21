package be.infernalwhale;

import be.infernalwhale.service.*;

public class Main {
    public static void main(String[] args) {
        Heater h = new HeaterImpl();
        Thermometer tm = new ThermometerImpl();

        Thermostat thermostat = new Thermostat(h, tm);

    }
}
