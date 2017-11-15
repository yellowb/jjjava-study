package week2.lesson1;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import week2.lesson1.Token.TokenType;

/**
 * 能读取String中Token的Reader
 */
public class ArithmeticTokenReader implements TokenReader {

    private Reader in;

    /**
     * The latest token
     */
    private Token currentToken;

    /**
     * Stores chars temporary
     */
    private StringBuilder buf;

    public ArithmeticTokenReader(Reader in) {
        this.in = in;
        currentToken = null;
        buf = new StringBuilder();
    }

    @Override
    public Token getToken() throws IOException {

        if (currentToken == null) {
            currentToken = findNextToken();
            return currentToken;
        } else {
            return currentToken;
        }
    }

    @Override
    public void consumeToken() {
        currentToken = null;
    }

    public Token findNextToken() throws IOException {
        // 如果一开始buf不为空, 意味着这是上读数字过程中读到的第一个不为数字的字符
        if (buf.length() > 0) {
            Token t = makeToken(buf.toString());
            buf.setLength(0);   // Clear buf
            return t;
        }
        // 如果buf为空, 则表示上一个Token已被取出, 或者是刚开始整个流程
        else {
            char c = (char) -1;
            while ((c = (char) this.in.read()) > -1) {
                if (buf.length() == 0) {
                    // buf为空并且第一个读到的字符不是数字, 就可以认定它是数字之外的其余token
                    if (!isNumericChar(c)) {
                        Token t = makeToken(String.valueOf(c));
                        return t;
                    }
                    // 如果读到的是数字字符, 则把它收集起来, 再看下一个字符是不是仍然是数字
                    else {
                        buf.append(c);
                    }
                } else {
                    // buf不为空并且读到的字符不是数字, 则意味着buf中收集的数字字符已经收集完, 可以把buf中的内容作为数字Token输出,
                    // 然后清空buf, 把当前字符缓存起来
                    if (!isNumericChar(c)) {
                        Token t = makeToken(buf.toString());
                        buf.setLength(0);   // Clear buf
                        buf.append(c);
                        return t;
                    }
                    // 仍然在收集数字字符
                    else {
                        buf.append(c);
                    }
                }
            }

            // 已经读到流的结束, 如果buf不为空, 则buf中的是最后一个Token
            if (buf.length() > 0) {
                Token t = makeToken(buf.toString());
                buf.setLength(0);   // Clear buf
                return t;
            }
            // 全部Token已读出, 再也不能读出任何东西
            else {
                Token t = makeToken("");
                return t;
            }
        }
    }

    /**
     * True if s can be convert to number
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        boolean ret = true;
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            ret = false;
        }
        return ret;
    }

    public boolean isNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    public Token makeToken(String s) {
        if (isNumber(s)) {
            // If it is number
            return new Token(TokenType.INT, Integer.valueOf(s));
        } else {
            // Other tokens
            switch (s) {
                case "(":
                    return new Token(TokenType.LPAR, s);
                case ")":
                    return new Token(TokenType.RPAR, s);
                case "+":
                    return new Token(TokenType.PLUS, s);
                case "-":
                    return new Token(TokenType.MINUS, s);
                case "*":
                    return new Token(TokenType.MULT, s);
                case "/":
                    return new Token(TokenType.DIV, s);
                default:
                    return new Token(TokenType.NONE, s);
            }
        }
    }


    public static void main(String[] args) {
        StringReader sr = new StringReader("(100+23)*(35-49)");
        TokenReader tr = new ArithmeticTokenReader(sr);
        try {
            Token token = tr.getToken();
            while (token.tokenType != TokenType.NONE) {
                System.out.println(token);
                tr.consumeToken();
                token = tr.getToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
