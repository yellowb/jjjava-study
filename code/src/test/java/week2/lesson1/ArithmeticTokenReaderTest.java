package week2.lesson1;

import org.junit.Test;
import org.junit.Before;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArithmeticTokenReaderTest {

    private String exp = "(100+23)*(35-49)";

    // (100+23)*(35-49)
    private Token[] tokenArr = {
            new Token(Token.TokenType.LPAR, "("),
            new Token(Token.TokenType.INT, new Integer(100)),
            new Token(Token.TokenType.PLUS, "+"),
            new Token(Token.TokenType.INT, new Integer(23)),
            new Token(Token.TokenType.RPAR, ")"),
            new Token(Token.TokenType.MULT, "*"),
            new Token(Token.TokenType.LPAR, "("),
            new Token(Token.TokenType.INT, new Integer(35)),
            new Token(Token.TokenType.MINUS, "-"),
            new Token(Token.TokenType.INT, new Integer(49)),
            new Token(Token.TokenType.RPAR, ")")

    };

    private List<Token> tokens = Arrays.asList(tokenArr);

    @Test
    public void test_TokenReader_Should_Tokenize_Correctly() throws IOException {

        List<Token> localTokens = new ArrayList<Token>();

        StringReader sr = new StringReader(exp);
        TokenReader tr = new ArithmeticTokenReader(sr);

        Token token = tr.getToken();
        while (token.tokenType != Token.TokenType.NONE) {
            localTokens.add(token);
            tr.consumeToken();
            token = tr.getToken();
        }

        assertEquals("The amount of tokens not correct.", tokens.size(), localTokens.size());

        for(int i = 0; i < tokens.size(); ++i) {
            assertEquals("The content of token not correct.", tokens.get(i), localTokens.get(i));
        }
    }

}
