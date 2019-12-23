package de.stea1th.program.arguments;

import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.flags.IFlag;
import de.stea1th.program.registry.FlagRegistry;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgumentParser {

    private List<String> registryKeys;

    private Map<String, Object> result = new HashMap<>();

    private FlagRegistry registry = FlagRegistry.getInstance();

    public ArgumentParser(List<String> registryKeys) {
        this.registryKeys = registryKeys;
    }

    public Map<String, Object> parse(OrganizerResult organizerResult) throws MyException {
        Map<String, ? extends Class<?>> registryRecords = registry.getRegistryRecords(registryKeys);

        for (Map.Entry<String, ? extends Class<?>> entry : registryRecords.entrySet()) {
            Map<String, String> argumentMap = organizerResult.getArgumentMap();
            String value = argumentMap.get(entry.getKey());
            IFlag object;
            try {
                object = value != null ? (IFlag) entry.getValue().getConstructor(String.class).newInstance(value) :
                        (IFlag) entry.getValue().getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new MyException(String.format("Can't create new object if parameter equal <%s>", e.getMessage()), e.getCause());
            }
            result.put("-" + entry.getKey(), object.getValue());
        }
        return result;
    }

    public Object getValue(String key) throws MyException {

        Object o = result.get(key);
        if (o == null) throw new MyException(String.format("This flag <%s> don't exists in this schema", key));
        return o;
    }
}
