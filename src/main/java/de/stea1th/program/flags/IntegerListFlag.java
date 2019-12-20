package de.stea1th.program.flags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Flag(name = "list of integers", flag = "d")
public class IntegerListFlag extends FlagBase<List<Integer>> {

    public IntegerListFlag(String line) {
        this.value = convertToList(line);
    }

    private List<Integer> convertToList(String line) {
        List<Integer> list = new ArrayList<>();
        try {
            list = Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return list;
    }
}
