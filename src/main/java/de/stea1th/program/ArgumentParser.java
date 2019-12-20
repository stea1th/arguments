package de.stea1th.program;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentParser {

    public ParseResult parse(String[] args) {
        ParseResult parseResult = new ParseResult();
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
                parseResult.put(key.replace("-", ""), value);
            } else {
                if (i == 0) {
                    parseResult.setExceptionMessage("False arguments begin");
                }
            }
        }
        return parseResult;
    }

}
