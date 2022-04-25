package be.infernalwhale.service;

import java.util.Random;

public class AtmosphericEvaluatorImpl implements AtmosphericEvaluator {
    @Override
    public int getTemperature()  {
        return new Random().nextInt(25);
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
}
