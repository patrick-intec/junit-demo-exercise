package be.infernalwhale.service;

public class HeaterImpl implements Heater {
    @Override
    public void turnOn()  {
        System.out.println("Heater is turning on....");
    }
}
