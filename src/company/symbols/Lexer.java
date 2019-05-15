package company.symbols;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import company.Util.*;

public abstract class Lexer {
    public static List<String> lexer = new ArrayList<>();
    public Lexer(){}
    public  Lexer(String FileName){
        try{
            lexer = FileReadUtil.ReadSymbols(FileName);
        }catch (FileNotFoundException e){
            System.out.println(FileName+"’“≤ªµΩ");
        }catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    protected List<String> GetLexer(){
        return lexer;
    }
    public abstract int GetKind();
    public abstract String GetDetail();
}


