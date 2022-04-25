package be.infernalwhale.service;

public interface AtmosphericEvaluator {
    int getTemperature();

    int getHumidity();

    int getAirPressure();

    int getCO2Levels();

    int getO2Levels();
}
