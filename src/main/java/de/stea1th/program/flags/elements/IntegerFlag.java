package de.stea1th.program.flags.elements;

import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "integer")
public class IntegerFlag extends FlagBase<Integer> {

    public IntegerFlag(String line) throws MyException {
        this.value = convertToInt(line);
    }

    private Integer convertToInt(String line) throws MyException {
        Integer result;
        if (line.equals("")) {
            result = 0;
        } else {
            try {
                result = Integer.valueOf(line);
            } catch (Exception e) {
                throw new MyException("Illegal arguments for integer cast. " + e.getMessage());
            }
        }
        return result;
    }
}
