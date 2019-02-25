package jtechlog.cleancode.args;

import java.util.List;

public abstract class ArgumentParser<T> {

    private static List<String> ARGUMENT_TYPE_DEFINITIONS = List.of("", "*", "#", "##", "[*]", "&");

    protected char argumentId;

    abstract T getValue();

    public ArgumentParser(char argumentId) {
        this.argumentId = argumentId;
    }

    public boolean isFlag() {
        return false;
    }

    public char getArgumentId() {
        return argumentId;
    }

    public static boolean isValidArgumentTypeDefinition(String format) {
        return ARGUMENT_TYPE_DEFINITIONS.contains(format);
    }

    public static ArgumentParser getParser(char argumentId, String argumentTypeDefinition) {
        switch (argumentTypeDefinition) {
            case "":
                return new BooleanParser(argumentId);
            case "*":
                return new StringParser(argumentId);
            case "#":
                return new IntParser(argumentId);
            case "##":
                return new DoubleParser(argumentId);
            case "[*]":
                return new StringArrayParser(argumentId);
            case "&":
                return new MapParser(argumentId);
            default:
                throw new UnsupportedOperationException("Programming error, see the ARGUMENT_TYPE_DEFINITIONS");
        }

    }

    abstract void parseArgument(String arg);

    abstract void handleNotFound();
}
