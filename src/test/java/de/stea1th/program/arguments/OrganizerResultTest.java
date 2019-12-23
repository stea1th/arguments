package de.stea1th.program.arguments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerResultTest {

    private OrganizerResult organizerResult;

    @BeforeEach
    void initTest() {
        organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-l", "logging");
        map.put("-d", "directory");
        map.put("-p", "port");
        organizerResult.setArgumentMap(map);
    }

    @Test
    void getSortedArgumentMap_GetFirst() {

        String expected = "-d";

        Map<String, String> sortedArgumentMap = organizerResult.getSortedArgumentMap();

        assertEquals(expected, sortedArgumentMap.keySet().stream().findFirst().get());
    }

    @Test
    void put_NewKeyAndValue_AddedToArgumentMap() {
        String key = "-t";
        String value = "time";

        organizerResult.put(key, value);
        Map<String, String> argumentMap = organizerResult.getArgumentMap();

        assertTrue(argumentMap.containsKey(key));
        assertEquals(value, argumentMap.get(key));

    }

    @Test
    void getSortedKeys() {
        String expected = "dlp";

        String sortedKeys = organizerResult.getSortedKeys();

        assertEquals(expected, sortedKeys);
    }
}
