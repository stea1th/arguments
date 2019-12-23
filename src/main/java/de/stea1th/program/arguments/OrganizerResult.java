package de.stea1th.program.arguments;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizerResult {

    private Map<String, String> argumentMap;

    OrganizerResult() {
        argumentMap = new LinkedHashMap<>();
    }

    void setArgumentMap(Map<String, String> argumentMap) {
        this.argumentMap = argumentMap;
    }

    public Map<String, String> getArgumentMap() {
        return argumentMap;
    }

    Map<String, String> getSortedArgumentMap() {
        return argumentMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (k, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", v));
                        }, LinkedHashMap::new));
    }

    void put(String key, String value) {
         argumentMap.put(key, value);
    }

    public String getSortedKeys() {
        return getSortedArgumentMap()
                .keySet()
                .stream()
                .map(k -> k.replace("-", ""))
                .collect(Collectors.joining());
    }
}
