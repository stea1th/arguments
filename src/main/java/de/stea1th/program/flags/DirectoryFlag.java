package de.stea1th.program.flags;

@Flag(name = "directory", flag = "d")
public class DirectoryFlag extends FlagBase<String> {

    public DirectoryFlag(String value) {
        this.value = value;
    }
}
