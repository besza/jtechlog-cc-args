package jtechlog.cleancode.args;

public class IntParser extends ArgumentParser<Integer> {

    private int value;

    public IntParser(char argumentId) {
        super(argumentId);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void parseArgument(String arg) {
        try {
            value = Integer.parseInt(arg);
        } catch (NumberFormatException nfe) {
            throw ArgsException.withDefaultMessage(ErrorCode.INVALID_INTEGER, argumentId, arg);
        }
    }

    @Override
    public void handleNotFound() {
        throw ArgsException.withDefaultMessage(ErrorCode.MISSING_INTEGER, argumentId);
    }
}
