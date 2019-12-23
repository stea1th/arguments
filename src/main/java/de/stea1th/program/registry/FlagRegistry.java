package de.stea1th.program.registry;

import de.stea1th.program.flags.Flag;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlagRegistry {

    private static FlagRegistry instance = null;

    private Map<String, ? extends Class<?>> registry;

    private FlagRegistry() {
        initRegistry();
    }

    public static FlagRegistry getInstance() {
        if(instance == null) {
            instance = new FlagRegistry();
        }
        return instance;
    }

    private void initRegistry() {
        Reflections reflections = new Reflections("de.stea1th.program.flags", new TypeAnnotationsScanner(), new SubTypesScanner());

        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Flag.class);

        registry = typesAnnotatedWith.stream().collect(Collectors.toMap(s -> s.getAnnotation(Flag.class).name(), s -> s));

        registry.forEach((k,v) -> System.out.println(k + " " +v));
    }

    public Map<String, ? extends Class<?>> getRegistryRecords(List<String> keys) {
        keys.forEach(s-> System.out.println(s));
        return keys.stream().map(key -> registry.get(key)).collect(Collectors.toMap(s-> s.getAnnotation(Flag.class).flag(), s -> s));
    }
}