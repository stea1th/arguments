package de.stea1th.program.arguments;

import de.stea1th.program.exceptions.MyException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentOrganizerTest {

    private static ArgumentOrganizer argumentOrganizer;

    @BeforeAll
    static void initClass() {
        argumentOrganizer = new ArgumentOrganizer();
    }

    @Test
    void organize_BeginWithIntegerValue_MyException() {
        String[] args = new String[] {"9999", "-l", "-d", "8080"};
        String expected = "<9999> false arguments begin.";

        Exception exception = assertThrows(MyException.class, ()-> argumentOrganizer.organize(args));

        assertEquals(expected, exception.getMessage());
    }

    @Test
    void organize_LWithoutValueDWithInteger_LGetEmptyStringAsValue() {
        String[] args = new String[] {"-l", "-d", "8080"};

        OrganizerResult organizerResult = argumentOrganizer.organize(args);
        Map<String, String> argumentMap = organizerResult.getArgumentMap();

        assertEquals("", argumentMap.get("-l"));
    }

    @Test
    void organize_ValueWithoutFlag_MyException() {
        String[] args = new String[] {"-p", "abracadabra", "/user", "-d", "8080"};
        String expected = "</user> argument without flag";

        Exception exception = assertThrows(MyException.class, ()-> argumentOrganizer.organize(args));

        assertEquals(expected, exception.getMessage());
    }

    @Test
    void organize_LFlagWithoutValueAtTheEnd_EmptyStringAsValue() {
        String[] args = new String[] {"-d", "8080", "-l"};

        OrganizerResult organizerResult = argumentOrganizer.organize(args);
        Map<String, String> argumentMap = organizerResult.getArgumentMap();

        assertEquals("", argumentMap.get("-l"));
    }
}
