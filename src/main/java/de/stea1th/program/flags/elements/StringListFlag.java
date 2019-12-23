package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

import java.util.Arrays;
import java.util.List;

@Flag(name = "list of strings")
public class StringListFlag extends FlagBase<List<String>> {

    public StringListFlag(String line) {
        this.value = convertToList(line);
    }

    private List<String> convertToList(String line) {
        return Arrays.asList(line.split(","));
    }
}
