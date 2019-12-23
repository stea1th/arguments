package de.stea1th.program;

import de.stea1th.program.arguments.ArgumentOrganizer;
import de.stea1th.program.arguments.ArgumentParser;
import de.stea1th.program.arguments.OrganizerResult;
import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.readers.ResourcesReader;

import java.util.Map;

@SuppressWarnings(value = "unchecked")
public class Main {

    public static void main(String[] args) {

        try {

            ArgumentOrganizer argumentOrganizer = new ArgumentOrganizer();
            OrganizerResult organizerResult = argumentOrganizer.organize(args);

            ResourcesReader resourcesReader = new ResourcesReader();
            Map<String, String> registryKeys = resourcesReader.readRegistryKeys(organizerResult.getSortedKeys());

            ArgumentParser argumentParser = new ArgumentParser(registryKeys);
            argumentParser.parse(organizerResult);

            boolean value = (boolean) argumentParser.getValue("-l");
            System.out.println(value);

        } catch (MyException | IllegalStateException e) {

            System.out.println(e.getMessage());
            System.out.println(e.getCause().getMessage());
            System.exit(-1);
        }
    }
}
