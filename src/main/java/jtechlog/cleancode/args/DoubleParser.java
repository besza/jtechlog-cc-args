package jtechlog.cleancode.args;

public class DoubleParser extends ArgumentParser<Double> {

    private double value;

    public DoubleParser(char argumentId) {
        super(argumentId);
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void parseArgument(String arg) {
        try {
            value = Double.parseDouble(arg);
        } catch (NumberFormatException nfe) {
            throw ArgsException.withDefaultMessage(ErrorCode.INVALID_DOUBLE, argumentId, arg);
        }
    }

    @Override
    public void handleNotFound() {
        throw ArgsException.withDefaultMessage(ErrorCode.MISSING_DOUBLE, argumentId);
    }
}
