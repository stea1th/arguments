package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.Flag;
import de.stea1th.program.flags.FlagBase;

@Flag(name = "port", flag = "p")
public class PortFlag extends FlagBase<Integer> {

    public PortFlag(String line) {
        this.value = convertToInt(line);
    }


    private Integer convertToInt(String line) {
        Integer result = null;
        if (line.equals("")) {
            result = 0;
        } else {
            try {
                result = Integer.valueOf(line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }
        return result;
    }
}
