package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "boolean")
public class BooleanFlag extends FlagBase<Boolean> {

    public BooleanFlag(String line) {
        this.value = true;
    }

    public BooleanFlag() {
        this.value = false;
    }
}
