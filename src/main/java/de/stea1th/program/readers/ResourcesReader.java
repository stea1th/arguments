package de.stea1th.program.readers;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;
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

    public List<String> readRegistryKeys(String key) {
        List<String> stringList = new ArrayList<>();
        try {
            Config config = ConfigFactory.parseResources(fileName);

            stringList = config.getStringList(String.format("schema.%s.names", key));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return stringList;
    }
}
