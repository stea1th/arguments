package de.stea1th.program.arguments;

import de.stea1th.program.exceptions.MyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentParserTest {

    private ArgumentParser argumentParser;

    @BeforeEach
    void initTest() {
        Map<String, String> registryKeys = new HashMap<>();
        registryKeys.put("-l", "boolean");
        registryKeys.put("-d", "string");
        registryKeys.put("-p", "integer");
        argumentParser = new ArgumentParser(registryKeys);
    }

    @Test
    void parse_NoLParameter_GetBooleanValue() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
        organizerResult.setArgumentMap(map);

        Map<String, Object> parse = argumentParser.parse(organizerResult);

        assertTrue(parse.get("-l") instanceof Boolean);
    }

    @Test
    void parse_PParameter_GetIntegerValue() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
        organizerResult.setArgumentMap(map);

        Map<String, Object> parse = argumentParser.parse(organizerResult);

        assertTrue(parse.get("-p") instanceof Integer);
    }

    @Test
    void parse_UnknownParameter_GetMyException() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-d", "/user/hallo");
        map.put("-p", "asd");
        organizerResult.setArgumentMap(map);
        String expected = "Can't create new object if parameter equal <null>";

        Exception exception = assertThrows(MyException.class, () -> argumentParser.parse(organizerResult));

        assertEquals(expected, exception.getMessage());

    }

    @Test
    void getValue_LEmptyParameter_GetTrue() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-l", "");
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
        organizerResult.setArgumentMap(map);
        argumentParser.parse(organizerResult);

        Boolean current = (Boolean) argumentParser.getValue("-l");

        assertEquals(true, current);
    }

    @Test
    void getValue_NoLParameter_GetFalse() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
        organizerResult.setArgumentMap(map);
        argumentParser.parse(organizerResult);

        Boolean current = (Boolean) argumentParser.getValue("-l");

        assertEquals(false, current);

    }
}
