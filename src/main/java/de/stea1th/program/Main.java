package de.stea1th.program;

public class Main {

    public static void main(String[] args) {

        String arguments = String.join(" ", args);
        ArgumentParser parser = new ArgumentParser();
        ParseResult parse = parser.parse(args);
        System.out.println(parse.getSortedKeys());

        new ResourcesReader("default.conf").read(parse.getSortedKeys()).forEach(System.out::println);



    }
}
