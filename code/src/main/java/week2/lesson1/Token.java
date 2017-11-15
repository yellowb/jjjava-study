package week2.lesson1;

import java.util.Objects;

public class Token {
    public enum TokenType {
        LPAR, RPAR, // 左右括号
        PLUS,   // 加号
        MINUS,  // 减号
        MULT,   // 乘号
        DIV,    // 除号
        INT,    // 数字
        BLANK,  // 空格
        NONE,   // 其它
    }

    public TokenType tokenType;
    public Object value;

    public Token(TokenType tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return tokenType == token.tokenType &&
                Objects.equals(value, token.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tokenType, value);
    }
}