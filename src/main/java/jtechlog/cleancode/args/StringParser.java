package jtechlog.cleancode.args;

public class StringParser extends ArgumentParser<String> {

    private String value;

    public StringParser(char argumentId) {
        super(argumentId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void parseArgument(String value) {
        this.value = value;
    }

    @Override
    public void handleNotFound() {
        throw ArgsException.withDefaultMessage(ErrorCode.MISSING_STRING, argumentId);
    }
}
