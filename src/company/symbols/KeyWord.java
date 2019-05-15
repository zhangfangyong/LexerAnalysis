package company.symbols;

import java.io.FileReader;
import java.util.List;

public class KeyWord extends Lexer{
    private static List<String> keywords;
    private static int Kind = 1;
    public KeyWord(String filename){
        super(filename);
        keywords = super.GetLexer();
    }
    public List<String> GetKeywordList(){
        return keywords;
    }
    public int GetKind() {
        return Kind;
    }
    public String GetDetail() {
        return "±£Áô×Ö";
    }
}
