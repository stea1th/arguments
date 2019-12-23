package de.stea1th.program.arguments;

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
    void parse() {
        OrganizerResult organizerResult = new OrganizerResult();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("-d", "/user/hallo");
        map.put("-p", "8080");
        organizerResult.setArgumentMap(map);




    }

    @Test
    void getValue() {
    }
}
