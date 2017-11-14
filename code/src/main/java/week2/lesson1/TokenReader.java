package week2.lesson1;

import java.io.IOException;

public interface TokenReader {
    public Token getToken() throws IOException;

    public void consumeToken();
}
