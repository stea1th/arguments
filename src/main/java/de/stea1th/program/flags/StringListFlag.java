package de.stea1th.program.flags;

import java.util.List;

@Flag(name = "list of strings", flag = "g")
public class StringListFlag implements IFlag<List<String>> {


    @Override
    public List<String> getValue() {
        return null;
    }
}
