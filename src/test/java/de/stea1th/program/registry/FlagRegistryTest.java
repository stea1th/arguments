package de.stea1th.program.registry;

import de.stea1th.program.exceptions.MyException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FlagRegistryTest {

    private static FlagRegistry flagRegistry;

    @BeforeAll
    static void initClass() {
        flagRegistry = FlagRegistry.getInstance();
    }

    @Test
    void getInstance_CheckIfThisSingleton() {

        FlagRegistry current = FlagRegistry.getInstance();

        assertSame(flagRegistry, current);
        assertNotNull(current);
    }

    @Test
    void getRegistryRecords_PutCorrectKeyMap_ExpectedClass() {
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("-l", "boolean");
        keyMap.put("-d", "string");
        String expected = "de.stea1th.program.flags.elements.BooleanFlag";

        Map<String, ? extends Class<?>> registryRecords = flagRegistry.getRegistryRecords(keyMap);

        assertEquals(expected, registryRecords.get("-l").getName());
    }

    @Test
    void getRegistryRecords_PutFalseKeyMap_ExpectedMyException() {
        Map<String, String> keyMap = new HashMap<>();
        String expected = "abrakadabra";
        keyMap.put("-p", expected);
        keyMap.put("-d", "list of integers");

        Exception exception = assertThrows(MyException.class, ()-> flagRegistry.getRegistryRecords(keyMap));

        assertTrue(exception.getMessage().contains(expected));
    }
}
