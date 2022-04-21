package be.infernalwhale.service;

public class BooleanWrapper {
    private boolean value;

    public BooleanWrapper(boolean initValue) {
        this.value = initValue;
    }

    public boolean isValue() {
        return value;
    }

    public BooleanWrapper setValue(boolean value) {
        this.value = value;
        return this;
    }
}
