package company.symbols;

public class Identifier extends Lexer {
    private static int Kind = 4;

    @Override
    public int GetKind() {
        return Kind;
    }

    @Override
    public String GetDetail() {
        return "±êÊ¶·û";
    }
}
