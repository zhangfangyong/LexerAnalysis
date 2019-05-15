package company.Gui;

import company.Main;
import company.Util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.IOException;

public class Control {
    public TableView<LexerResult> resultTable;
    public TableColumn<LexerResult, String> LineColumn;
    public TableColumn<LexerResult, String> SymbolColumn;
    public TableColumn<LexerResult, String> KindColumn;
    public TableColumn<LexerResult, String> DetailColumn;
    public Label filePath;
    public TextArea code;
    private static ObservableList<LexerResult> lexResults;
    private Main main;

    public void compile(ActionEvent actionEvent) {

        // Add observable list data to the table
        System.out.println(main.getLoadFile());
        if (main.getLoadFile() == null) {
            filePath.setText("未导入文件");
        } else {
            setCode(main.getLoadFile());
            if (lexResults != null) lexResults.clear();
            lexResults = FXCollections.observableArrayList(LexerUtil.LexicalAnalysis(main.getLoadFile()));
            resultTable.setItems(lexResults);
        }
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    @FXML
    private void initialize() {
        // Initialize the table with the two columns.
        LineColumn.setCellValueFactory(
                cellData ->  cellData.getValue().lineProperty());
        SymbolColumn.setCellValueFactory(
                cellData -> cellData.getValue().symbolProperty());
        KindColumn.setCellValueFactory(
                cellData -> cellData.getValue().KindProperty());
        DetailColumn.setCellValueFactory(
                cellData -> cellData.getValue().detailProperty());

    }

    public void setMainApp(Main mainApp) {
        this.main = mainApp;
    }

    public void setCode(File file) {
        try {
            filePath.setText(file.getPath());
            code.setText(FileReadUtil.GetCode(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
