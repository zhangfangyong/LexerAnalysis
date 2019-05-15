package company.symbols;

public class ErrorSign extends Lexer {
    private static int Kind = 6;

    @Override
    public int GetKind() {
        return Kind;
    }

    @Override
    public String GetDetail() {
        return "´íÎó";
    }
}
