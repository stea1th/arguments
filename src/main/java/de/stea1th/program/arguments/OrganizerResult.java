package de.stea1th.program.arguments;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizerResult {

    private Map<String, String> argumentMap;

    public OrganizerResult() {
        argumentMap = new LinkedHashMap<>();
    }

    public Map<String, String> getArgumentMap() {
        return argumentMap;
    }


    public String put(String key, String value) {
        return argumentMap.put(key, value);
    }

    public String get(String key) {
        return argumentMap.get(key);
    }

    public String getSortedKeys() {
        return argumentMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());
    }


}
