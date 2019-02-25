package jtechlog.cleancode.args;

import java.util.HashMap;
import java.util.Map;

public class MapParser extends ArgumentParser<Map<String, String>> {

    private static final String MAP_ENTRY_SEPARATOR = ",";

    private Map<String, String> value = new HashMap<>();

    public MapParser(char argumentId) {
        super(argumentId);
    }

    @Override
    public Map<String, String> getValue() {
        return value;
    }

    @Override
    public void parseArgument(String arg) {
        String[] entries = arg.split(MAP_ENTRY_SEPARATOR);
        for (String entry : entries) {
            addEntry(entry);
        }
    }

    private void addEntry(String entry) {
        String[] tokens = entry.split(":");
        if (tokens.length != 2) {
            throw ArgsException.withDefaultMessage(ErrorCode.MALFORMED_MAP, argumentId);
        }
        value.put(tokens[0], tokens[1]);
    }

    @Override
    public void handleNotFound() {
        throw ArgsException.withDefaultMessage(ErrorCode.MISSING_MAP, argumentId);
    }
}
