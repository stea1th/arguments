package de.stea1th.program.flags.elements;

import de.stea1th.program.exceptions.MyException;
import de.stea1th.program.flags.IFlag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListFlagTest {

    @Test
    void createObjectWithCorrectIntegerValues_GetIntegerList() {
        String line = "12,4,-6,3";
        int expected = -6;

        IFlag<List<Integer>> object = new IntegerListFlag(line);

        assertEquals(4, object.getValue().size());
        assertEquals(expected, object.getValue().get(2));
    }

    @Test
    void createObjectWithInvalidIntegerValues_GetIntegerList() {
        String line = "12,ab,-6,3";
        String expected = "Illegal arguments for integer cast. For input string: \"ab\"";

        Exception exception = assertThrows(MyException.class, ()-> new IntegerListFlag(line));

        assertEquals(expected, exception.getMessage());
    }
}
