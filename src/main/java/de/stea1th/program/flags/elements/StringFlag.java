package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "string")
public class StringFlag extends FlagBase<String> {

    public StringFlag(String value) {
        this.value = value;
    }
}
