package week2.lesson3;

import week2.lesson1.*;
import week2.lesson1.Token.TokenType;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 后缀表达式计算器
 */
public class RevPolishNotationCalculator {

    /**
     * 解析并计算后缀表达式
     *
     * @param exp
     * @return 计算结果
     * @throws IllegalArgumentException 如果不是一个合法的后缀表达式
     */
    public int calculate(String exp) throws IllegalArgumentException, IOException {
        List<Token> tokens = tokenize(exp);
        int result = calculate(tokens);
        return result;
    }

    /**
     * Parse expression into tokens.
     * @param exp
     * @return
     * @throws IOException
     */
    private List<Token> tokenize(String exp) throws IOException {
        List<Token> tokens = new ArrayList<Token>();
        StringReader sr = new StringReader(exp);
        TokenReader tr = new ArithmeticTokenReader(sr);
        Token token = tr.getToken();
        // Read until ends.
        while (token.tokenType != Token.TokenType.NONE) {
            tokens.add(token);
            tr.consumeToken();
            token = tr.getToken();
        }
        return tokens;
    }

    /**
     * Calculate final result by tokens.
     * @param tokens
     * @return
     * @throws IllegalArgumentException
     */
    private int calculate(List<Token> tokens) throws IllegalArgumentException {
        // Use stack to do 2-arguments calculation
        GoodStack<Token> stack = new GoodStack<Token>(tokens.size());

        for(Token token : tokens) {
            switch (token.tokenType) {
                // If this is an integer, then push it to stack.
                case INT: {
                    stack.push(token);
                    break;
                }
                // If token is +-*/ operators, then pop 2 tokens from stack and calculate them.
                case PLUS:
                case MINUS:
                case MULT:
                case DIV: {
                    Token b = stack.pop();
                    Token a = stack.pop();
                    Token c = calculate(a, b, token);
                    stack.push(c);
                    break;
                }
                case BLANK: break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        // The last only token in the stack should be final result.
        Token result = stack.pop();
        if(result.tokenType == TokenType.INT && stack.isEmpty()) {
            return (Integer) result.value;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 四则运算 2-arguments calculation
     * @param a
     * @param b
     * @param op
     * @return
     */
    private Token calculate(Token a, Token b, Token op) {
        int result = 0;
        switch (op.tokenType) {
            case PLUS:
                result = (Integer)(a.value) + (Integer)(b.value);
                break;
            case MINUS:
                result = (Integer)(a.value) - (Integer)(b.value);
                break;
            case MULT:
                result = (Integer)(a.value) * (Integer)(b.value);
                break;
            case DIV:
                result = (Integer)(a.value) / (Integer)(b.value);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return new Token(TokenType.INT, Integer.valueOf(result));
    }

    public static void main(String[] args) {
        String exp = "8 5 - 4 2 - *";
        try {
            int result = new RevPolishNotationCalculator().calculate(exp);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
