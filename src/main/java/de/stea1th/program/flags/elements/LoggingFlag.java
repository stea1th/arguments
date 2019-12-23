package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "logging")
public class LoggingFlag extends FlagBase<Boolean> {

    public LoggingFlag(String line) {
        this.value = true;
    }

    public LoggingFlag() {
        this.value = false;
    }
}
