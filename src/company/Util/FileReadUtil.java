package company.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  FileReadUtil {
    public static List<String> ReadSymbols(String filename) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        List<String> list=new ArrayList<>();
        while ((s=in.readLine()) != null) list.add(s);
        in.close();
        return list;
    }


    public static String GetCode(File file) throws IOException {
        int currentLine = 1;
        BufferedReader in = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(currentLine < 10 ? currentLine + "   |  " : currentLine + " |  ");  //¶ÔÆëÐÐºÅ
            sb.append(s);
            sb.append("\n");
            currentLine++;
        }
        in.close();
        return sb.toString();
    }
}
