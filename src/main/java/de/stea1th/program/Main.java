package de.stea1th.program;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String arguments = String.join(" ", args);
        ArgumentParser parser = new ArgumentParser();
        ParseResult parse = parser.parse(args);
        System.out.println(parse.getSortedKeys());

        List<String> list = new ResourcesReader("default.conf").read(parse.getSortedKeys());

        Map<String, ? extends Class<?>> registry = new FlagRegistry().getRegistry();

    }
}
