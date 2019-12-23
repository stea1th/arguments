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
        map.put("-l", "");
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
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
        String value = "12:50";

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
