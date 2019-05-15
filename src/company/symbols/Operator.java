package company.symbols;

import java.util.List;

public class Operator extends Lexer {
    private static List<String> operators;
    private static int Kind = 2;
    public Operator(String filename){
        super(filename);
        operators = super.GetLexer();
    }
    public List<String> GetOperatorList(){
        return operators;
    }

    @Override
    public int GetKind() {
        return Kind;
    }

    @Override
    public String GetDetail() {
        return "ÔËËã·û";
    }
}
