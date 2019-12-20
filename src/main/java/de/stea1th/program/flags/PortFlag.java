package de.stea1th.program.flags;

@Flag(name = "port", flag = "p")
public class PortFlag implements IFlag<Integer> {

    private Integer value;

    public PortFlag(String line) {
        this.value = convertString(line);
    }


    private Integer convertString(String line) {
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

    @Override
    public Integer getValue() {
        return value;
    }
}
