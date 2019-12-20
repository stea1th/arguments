package de.stea1th.program;

import de.stea1th.program.flags.Flag;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlagRegistry {


    public Map<String, ? extends Class<?>> getRegistry() {
        Reflections reflections = new Reflections("de.stea1th.program.flags", new TypeAnnotationsScanner(), new SubTypesScanner());

        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(Flag.class);

        return typesAnnotatedWith.stream().collect(Collectors.toMap(s -> s.getAnnotation(Flag.class).name(), s -> s));
    }
}
