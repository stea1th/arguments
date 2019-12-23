package de.stea1th.program;

import de.stea1th.program.arguments.ArgumentOrganizer;
import de.stea1th.program.arguments.ArgumentParser;
import de.stea1th.program.arguments.OrganizerResult;
import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.readers.ResourcesReader;

import java.util.List;

@SuppressWarnings(value = "unchecked")
public class Main {

    public static void main(String[] args) {

        try {
            ArgumentOrganizer argumentOrganizer = new ArgumentOrganizer();
            OrganizerResult organizerResult = argumentOrganizer.organize(args);

            ResourcesReader resourcesReader = new ResourcesReader();
            resourcesReader.readRegistryKeys(organizerResult.getSortedKeys());
//            List<String> registryKeys = resourcesReader.readRegistryKeys(organizerResult.getSortedKeys());

//            ArgumentParser argumentParser = new ArgumentParser(registryKeys);
//            argumentParser.parse(organizerResult);
//
//            List<Integer> value = (List<Integer>) argumentParser.getValue("-d");
//            System.out.println(value);

        } catch (MyException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
        } finally {
            System.exit(-1);
        }
    }
}
