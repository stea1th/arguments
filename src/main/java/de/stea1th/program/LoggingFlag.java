package de.stea1th.program;

public class LoggingFlag implements Flag<Boolean> {

    private String name = "logging";

    private Boolean value;

    public LoggingFlag(String line) {
        this.value = true;
    }

    public LoggingFlag() {
        this.value = false;
    }

    @Override
    public Boolean getValue() {
        return value;
    }
}
