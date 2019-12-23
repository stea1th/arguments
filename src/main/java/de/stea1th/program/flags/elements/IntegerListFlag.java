package de.stea1th.program.flags.elements;

import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Flag(name = "list of integers", flag = "d")
public class IntegerListFlag extends FlagBase<List<Integer>> {

    public IntegerListFlag(String line) throws MyException {
        this.value = convertToList(line);
    }

    private List<Integer> convertToList(String line) throws MyException {
        List<Integer> list;
        try {
            list = Arrays.stream(line.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        } catch (Exception e) {
            throw new MyException("Illegal arguments for integer cast. " + e.getMessage());
        }
        return list;
    }
}
