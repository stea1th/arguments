package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "directory", flag = "d")
public class DirectoryFlag extends FlagBase<String> {

    public DirectoryFlag(String value) {
        this.value = value;
    }
}
