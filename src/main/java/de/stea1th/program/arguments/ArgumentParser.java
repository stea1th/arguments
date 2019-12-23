package de.stea1th.program.arguments;

import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.flags.IFlag;
import de.stea1th.program.registry.FlagRegistry;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ArgumentParser {

    private Map<String, String> registryKeys;

    private Map<String, Object> result = new HashMap<>();

    private FlagRegistry registry = FlagRegistry.getInstance();

    public ArgumentParser(Map<String, String> registryKeys) {
        this.registryKeys = registryKeys;
    }

    public Map<String, Object> parse(OrganizerResult organizerResult) throws MyException {
        Map<String, ? extends Class<?>> registryRecords = registry.getRegistryRecords(registryKeys);

        registryRecords.forEach((key, value) -> {
            Map<String, String> argumentMap = organizerResult.getSortedArgumentMap();
            String argument = argumentMap.get(key);
            IFlag object;
            try {
                object = argument != null ? (IFlag) value.getConstructor(String.class).newInstance(argument) :
                        (IFlag) value.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new MyException(String.format("Can't create new object if parameter equal <%s>", e.getMessage()), e.getCause());
            }
            result.put(key, object.getValue());
        });
        return result;
    }

    public Object getValue(String key) throws MyException {

        Object o = result.get(key);
        if (o == null) throw new MyException(String.format("This flag <%s> don't exists in this schema", key));
        return o;
    }
}
