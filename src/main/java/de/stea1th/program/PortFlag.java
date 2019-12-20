package de.stea1th.program;

public class PortFlag implements Flag<Integer> {

    private String name = "port";

    private Integer value;

    public PortFlag() {
        value = 0;
    }

    public PortFlag(String value) {
        this.value = convertString(value);
    }


    private Integer convertString(String line) {
        Integer result = null;
        try {
            result = Integer.valueOf(line);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
