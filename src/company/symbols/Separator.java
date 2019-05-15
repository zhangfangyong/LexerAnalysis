package company.symbols;

import java.util.List;

public class Separator extends Lexer {
    private static List<String> separators;
    private static int Kind = 3;
    public Separator(String filename){
        super(filename);
        separators = super.GetLexer();
    }
    public List<String> GetSeparatorList() {
        return separators;
    }

    @Override
    public int GetKind() {
        return Kind;
    }

    @Override
    public String GetDetail() {
        return "·Ö½ç·û";
    }
}
