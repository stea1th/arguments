package de.stea1th.program.readers;

import de.stea1th.program.exceptions.MyException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResourcesReaderTest {

    private ResourcesReader resourcesReader;

    @BeforeEach
    void initTest() {
        resourcesReader = new ResourcesReader();
    }

    @Test
    void readRegistryKeys_PutKeyDLP_ReturnLogging() {

        String expected = "logging";
        String schema = "dlp";
        String key = "-l";
        int count = 3;


        Map<String, String> currentMap = resourcesReader.readRegistryKeys(schema);

        assertEquals(count, currentMap.size());
        assertEquals(expected, currentMap.get(key));
    }

    @Test
    void readRegistryKeys_PutFalseSchema_ExpectedMyException() {

        String falseSchema = "tdb";

        Exception exception = assertThrows(MyException.class, ()-> resourcesReader.readRegistryKeys(falseSchema));

        assertTrue(exception.getMessage().contains(falseSchema));
    }
}
