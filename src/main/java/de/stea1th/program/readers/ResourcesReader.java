package de.stea1th.program.readers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import de.stea1th.program.exceptions.MyException;

import java.util.List;

public class ResourcesReader {

    private String fileName;

    private final static String DEFAULT_FILE_NAME = "default.conf";

    public ResourcesReader() {
        this.fileName = DEFAULT_FILE_NAME;
    }

    public ResourcesReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readRegistryKeys(String key) throws MyException {
        List<String> stringList;
        try {
            Config config = ConfigFactory.parseResources(fileName);

            stringList = config.getStringList(String.format("schema.%s.names", key));
        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
        return stringList;
    }
}
