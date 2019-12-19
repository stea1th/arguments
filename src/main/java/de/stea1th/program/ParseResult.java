package de.stea1th.program;

import java.util.HashMap;
import java.util.Map;

public class ParseResult {

    private Map<String, String> argumentMap;

    private String exceptionMessage;

    public ParseResult() {
        argumentMap = new HashMap<>();
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


}
