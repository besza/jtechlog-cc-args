package jtechlog.cleancode.args;

import java.util.Collections;
import java.util.Map;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SchemaReader {

    public Map<Character, String> readSchema(String schema) {
        if (schema.isBlank()) {
            return Collections.emptyMap();
        }

        return Arrays.stream(schema.split(","))
                .map(String::trim)
                .collect(Collectors.toMap(this::argumentIdMapper, this::argumentDefinitionMapper));
    }

    private Character argumentIdMapper(String token) {
        var argumentId = token.charAt(0);
        if (!Character.isLetter(argumentId)) {
            throw ArgsException.withDefaultMessage(ErrorCode.INVALID_ARGUMENT_ID, argumentId);
        }
        return argumentId;
    }

    private String argumentDefinitionMapper(String token) {
        var argumentTypeDefinition = token.substring(1);
        if (!ArgumentParser.isValidArgumentTypeDefinition(argumentTypeDefinition)) {
            throw ArgsException.withDefaultMessage(ErrorCode.INVALID_FORMAT, token.charAt(0)); //TODO: should not repeat
        }
        return argumentTypeDefinition;
    }

}
