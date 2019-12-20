package de.stea1th.program.flags;

@Flag(name = "directory", flag = "d")
public class DirectoryFlag implements IFlag<String>{

    private String value;

    public DirectoryFlag(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
