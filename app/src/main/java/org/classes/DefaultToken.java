package org.classes;

public class DefaultToken implements Token {

    TokenState state;

    @Override
    public void changeState(TokenState symbol) {
        this.state = symbol;
    }

    @Override
    public TokenState fetchSymbol() {
        return this.state;
    }

}
