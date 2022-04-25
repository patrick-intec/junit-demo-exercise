package be.infernalwhale;

import be.infernalwhale.service.*;

public class Main {
    public static void main(String[] args) {
        Heater h = new HeaterImpl();
        AtmosphericEvaluator tm = new AtmosphericEvaluatorImpl();

        Thermostat thermostat = new Thermostat(h, tm);

    }
}
