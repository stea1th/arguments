package de.stea1th.program.flags;

@Flag(name = "logging", flag = "l")
public class LoggingFlag implements IFlag<Boolean> {

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
