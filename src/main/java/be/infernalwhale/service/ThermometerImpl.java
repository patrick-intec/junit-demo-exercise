package be.infernalwhale.service;

import java.util.Random;

public class ThermometerImpl implements Thermometer {
    @Override
    public int getTemperature()  {
        return new Random().nextInt(25);
    }
}
