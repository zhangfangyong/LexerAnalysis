package company.Gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LexerResult {
    private static int temp = 1;
    private static int list = 0;
    private final StringProperty line;
    private final StringProperty symbol;
    private final StringProperty kind;
    private final StringProperty detail;
    public LexerResult() {this(null,null,null,null);
    }

    public LexerResult(String line ,String symbol, String kind, String detail) {
        if(temp==Integer.valueOf(line)){
            list++;
        }
        else {
            list = 1;
        }
        this.line = new SimpleStringProperty("("+line+","+String.valueOf(list)+")");
        this.symbol = new SimpleStringProperty(symbol);
        this.kind = new SimpleStringProperty(kind);
        this.detail = new SimpleStringProperty(detail);
        temp=Integer.valueOf(line);
    }
    public String getLine() {
        return line.get();
    }

    public StringProperty lineProperty() {
        return  line;
}

    public void setLine(String line) {
        this.line.set(line);
    }

    public String getSymbol() {
        return symbol.get();
    }

    public StringProperty symbolProperty() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol.set(symbol);
    }

    public String getKind() {
        return kind.get();
    }

    public StringProperty KindProperty() {
        return kind;
    }

    public void setKind(String Kind) { this.kind.set(Kind); }

    public String getDetail() {
        return detail.get();
    }

    public StringProperty detailProperty() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail.set(detail);
    }

    @Override
    public String toString() {
        return "LexResult{" +
                "line="  +line +
                ", symbol=" + symbol +
                ", Kind=" + kind +
                ", detail=" + detail +
                '}';
    }
}
