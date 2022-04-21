package be.infernalwhale;

public class ChangeableString {
    private String internalString;

    public String getInternalString() {
        return internalString;
    }


    public ChangeableString setInternalString(String internalString) {
        this.internalString = internalString;
        return this;
    }
}
