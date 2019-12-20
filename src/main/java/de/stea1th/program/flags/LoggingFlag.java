package de.stea1th.program.flags;

@Flag(name = "logging", flag = "l")
public class LoggingFlag extends FlagBase<Boolean> {

    public LoggingFlag(String line) {
        this.value = true;
    }

    public LoggingFlag() {
        this.value = false;
    }
}
