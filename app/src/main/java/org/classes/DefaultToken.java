package org.classes;

public final class DefaultToken implements Token {

    private TokenState state;

    @Override
    public void changeState(TokenState symbol) {
        this.state = symbol;
    }

    @Override
    public TokenState fetchSymbol() {
        return this.state;
    }

}
