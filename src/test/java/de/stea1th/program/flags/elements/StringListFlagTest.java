package de.stea1th.program.flags.elements;

import de.stea1th.program.flags.IFlag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListFlagTest {

    @Test
    void createObjectWithCorrectStringValuesSeparatedWithComma_GetStringList() {
        String line = "this,is,my,test";
        String expected = "my";

        IFlag<List<String>> object = new StringListFlag(line);

        assertEquals(4, object.getValue().size());
        assertEquals(expected, object.getValue().get(2));

    }

}
