package de.stea1th.program;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParseResult {

    private Map<String, String> argumentMap;

    private String exceptionMessage;

    public ParseResult() {
        argumentMap = new LinkedHashMap<>();
    }

    public Map<String, String> getArgumentMap() {
        return argumentMap;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
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
