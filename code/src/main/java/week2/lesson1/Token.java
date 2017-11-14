package week2.lesson1;

public class Token {
    public enum TokenType {
        LPAR, RPAR, // 左右括号
        PLUS,   // 加号
        MINUS,  // 减号
        MULT,   // 乘号
        DIV,    // 除号
        INT,    // 数字
        NONE,   // 空白字符
    }

    public TokenType tokenType;
    public Object value;

    public Token(TokenType tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }
}