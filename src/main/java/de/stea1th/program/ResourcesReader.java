package de.stea1th.program;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.ArrayList;
import java.util.List;

public class ResourcesReader {

    private String fileName;

    public ResourcesReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> read(String key) {
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
