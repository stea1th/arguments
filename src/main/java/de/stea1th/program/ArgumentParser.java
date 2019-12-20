package de.stea1th.program;

import de.stea1th.program.flags.IFlag;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {

    private Map<String, ? extends Class<?>> registryRecords;

    private Map<String, Object> result = new HashMap<>();

    public ArgumentParser(Map<String, ? extends Class<?>> registryRecords) {
        this.registryRecords = registryRecords;
    }

    public Map<String, Object> parse(OrganizerResult organizerResult) {
        for (Map.Entry<String, ? extends Class<?>> entry : registryRecords.entrySet()) {
            Map<String, String> argumentMap = organizerResult.getArgumentMap();
            String value = argumentMap.get(entry.getKey());
            IFlag object = null;
            try {
                object = value != null ? (IFlag) entry.getValue().getConstructor(String.class).newInstance(value) :
                        (IFlag) entry.getValue().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                System.out.println(e.getMessage());
                System.exit(-1);
            }
            System.out.println(object.getValue().getClass());
            result.put("-" + entry.getKey(), object.getValue());
        }
        return result;
    }

    public Object getValue(String key) {
        return result.get(key);
    }
}
