package de.stea1th.program.readers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigList;
import com.typesafe.config.ConfigObject;
import de.stea1th.program.exceptions.MyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResourcesReader {

    private String fileName;

    private final static String DEFAULT_FILE_NAME = "default.conf";

    public ResourcesReader() {
        this.fileName = DEFAULT_FILE_NAME;
    }

    public ResourcesReader(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, String> readRegistryKeys(String key) throws MyException {

        Map<String, String> map = new HashMap<>();
        try {
            System.out.println(key);
            Config config = ConfigFactory.parseResources(fileName);

            config.getObjectList(String.format("schema.%s", key)).forEach(c -> c.forEach((key1, value) -> map.put(key1, value.render())));

            System.out.println(map.get("-d"));

        } catch (Exception e) {
            throw new MyException(e.getMessage());
        }
        return map;
    }
}
