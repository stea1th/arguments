package de.stea1th.program.flags;

import java.util.Arrays;
import java.util.List;

@Flag(name = "list of strings", flag = "g")
public class StringListFlag extends FlagBase<List<String>> {

    public StringListFlag(String line) {
        this.value = convertToList(line);
    }

    private List<String> convertToList(String line) {
        return Arrays.asList(line.split(","));
    }
}
