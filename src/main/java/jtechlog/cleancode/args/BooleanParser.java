package jtechlog.cleancode.args;

public class BooleanParser extends ArgumentParser<Boolean> {

    public BooleanParser(char argumentId) {
        super(argumentId);
    }

    @Override
    public Boolean getValue() {
        return true;
    }

    @Override
    public boolean isFlag() {
        return true;
    }

    @Override
    public void parseArgument(String arg) {
        throw new UnsupportedOperationException("Should not have value");
    }

    @Override
    public void handleNotFound() {
        throw new UnsupportedOperationException("Should not have value");
    }
}
