package week2.lesson1;

import java.io.IOException;
import java.io.Reader;

/**
 * 能读取String中Token的Reader
 */
public class ArithmeticTokenReader implements TokenReader {

    private Reader in;

    /**
     * The latest token
     */
    private StringBuilder currentToken;

    /**
     * True if current token had been consumed.
     */
    private boolean consumed;

    public ArithmeticTokenReader(Reader in) {
        this.in = in;
        currentToken = new StringBuilder();
        consumed = false;
    }

    @Override
    public Token getToken() throws IOException {
        //TODO
        return null;
    }

    @Override
    public void consumeToken() {
        //TODO

    }
}
