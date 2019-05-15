package company.Util;

import company.symbols.*;
import company.Gui.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LexerUtil {
    private final static String Keyword_Path = "symbols\\keywords.txt";
    private final static String Operator_Path = "symbols\\operators.txt";
    private final static String Separator_Path = "symbols\\separators.txt";
    private final static KeyWord keyWord = new KeyWord(Keyword_Path);
    private final static Operator operator = new Operator(Operator_Path);
    private final static Separator separator = new Separator(Separator_Path);
    private final static UnsignedNumber unsignedNumber = new UnsignedNumber();
    private final static Identifier identifier = new Identifier();
    private final static ErrorSign Error_ = new ErrorSign();

    public static List<LexerResult> LexicalAnalysis(File file) {
        int currentLine = 1;
        List<LexerResult> lexResultList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            List<String> list;
            while ((s = in.readLine()) != null) {
                list = division(s);
                for (String symbol : list) {
                    Lexer currentType;
                    if      (isKeyWord(symbol))     currentType = keyWord;
                    else if (isOperator(symbol))    currentType = operator;
                    else if (isSeparator(symbol))   currentType = separator;
                    else {
                        try {
                            Float.valueOf(symbol);
                            currentType = unsignedNumber;
                        } catch (NumberFormatException e) {
                            if(symbol.charAt(0)>='0' && symbol.charAt(0)<='9'){
                                currentType=Error_;
                            }else {
                                currentType = identifier;
                            }
                        }
                    }
                    LexerResult lexResult = new LexerResult(String.valueOf(currentLine), symbol,
                     String.valueOf(currentType.GetKind()), currentType.GetDetail());
                    lexResultList.add(lexResult);
                }
                currentLine++;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lexResultList;
    }

    //得到一行中分割后的字符列表
    private static List<String> division(String s) {
        char[] chars = s.trim().toCharArray();  //去除首尾空格并转化为字符数组
        List<String> list = new ArrayList<>();  //保存组合出的单词和字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (isOperator(String.valueOf(chars[i])) || isSeparator(String.valueOf(chars[i])) || chars[i] == ' ') {
                if (sb.length() != 0) list.add(sb.toString().replaceAll(" ", ""));
                if (chars[i] != ' ') list.add(String.valueOf(chars[i]));
                sb.delete(0, sb.length());  //清空StringBuilder
                continue;
            }
            sb.append(chars[i]);
        }
        return list;
    }
    private static boolean isKeyWord(String s) {
        return keyWord.GetKeywordList().contains(s);
    }
    private static boolean isOperator(String s) {
        return operator.GetOperatorList().contains(s);
    }
    private static boolean isSeparator(String s) {
        return separator.GetSeparatorList().contains(s);
    }
}
