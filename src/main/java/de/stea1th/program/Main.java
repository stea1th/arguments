package de.stea1th.program;

import java.util.List;

@SuppressWarnings (value="unchecked")
public class Main {

    public static void main(String[] args) {

        ArgumentOrganizer argumentOrganizer = new ArgumentOrganizer();
        OrganizerResult organizerResult = argumentOrganizer.organize(args);

        ResourcesReader resourcesReader = new ResourcesReader();
        List<String> registryKeys = resourcesReader.readRegistryKeys(organizerResult.getSortedKeys());

        FlagRegistry registry = FlagRegistry.getInstance();

        ArgumentParser argumentParser = new ArgumentParser(registry.getRegistryRecords(registryKeys));
        argumentParser.parse(organizerResult);

        String list = (String) argumentParser.getValue("-d");
//        list.forEach(System.out::println);
//        System.out.println(list.get(0) != null);
        System.out.println(list);
    }
}
