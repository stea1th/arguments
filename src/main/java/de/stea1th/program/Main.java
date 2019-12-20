package de.stea1th.program;

import de.stea1th.program.flags.IFlag;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        ArgumentParser parser = new ArgumentParser();
        ParseResult parseResult = parser.parse(args);

        List<String> keys = new ResourcesReader("default.conf").read(parseResult.getSortedKeys());

        FlagRegistry registry = FlagRegistry.getInstance();
        Map<String, ? extends Class<?>> registryRecords = registry.getRegistryRecords(keys);

        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, ? extends Class<?>> entry : registryRecords.entrySet()) {
            Map<String, String> argumentMap = parseResult.getArgumentMap();
            String value = argumentMap.get(entry.getKey());
            IFlag object = value != null ? (IFlag) entry.getValue().getConstructor(String.class).newInstance(value) :
                    (IFlag) entry.getValue().getConstructor().newInstance();
            result.put(entry.getKey(), object.getValue());

//            System.out.println(object.getValue().getClass().getSimpleName() + " -> " + object.getValue());
        }
        result.values().forEach(System.out::println);
    }
}
