package de.stea1th.program.arguments;

import de.stea1th.program.exceptions.MyException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentOrganizer {

    public OrganizerResult organize(String[] args) throws MyException {
        OrganizerResult organizerResult = new OrganizerResult();
        Pattern pattern = Pattern.compile("-\\w");

        for (int i = 0; i < args.length; i++) {
            Matcher matcher = pattern.matcher(args[i]);
            if (matcher.matches()) {
                String key = matcher.group();
                String value;
                if (i + 1 < args.length) {
                    value = pattern.matcher(args[i + 1]).matches() ? "" : args[i + 1];
                } else {
                    value = "";
                }
//                organizerResult.put(key.replace("-", ""), value);
                organizerResult.put(key, value);
            } else {
                if (i == 0) {
                    throw new MyException(String.format("<%s> false arguments begin.", args[i]));
                }
            }
        }
        return organizerResult;
    }
}
