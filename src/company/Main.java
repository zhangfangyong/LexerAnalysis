package company;

import company.Gui.Control;
import company.Gui.LexerResult;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Main extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<LexerResult> lexResults = FXCollections.observableArrayList();
    private static File loadFile = new File("D:\\Programcode\\Java\\LexerAnalysis\\test.txt");  //将要进行词法分析的文件
    private static Control control;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("词法分析器");

        initRootLayout();
        showLexOverView();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Main() {
        // Add some sample data
      //  lexResults.add(new LexerResult("无", "无", "无", "无"));
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("company/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the overview inside the root layout.
     */
    public void showLexOverView() {
        try {
            // Load overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getClassLoader().getResource("company/View.fxml"));
            AnchorPane lexOverview = (AnchorPane) loader.load();


            // Set overview into the center of root layout.
            rootLayout.setCenter(lexOverview);

            control = loader.getController();
            control.setMainApp(this);
            control.resultTable.setItems(lexResults);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<LexerResult> getLexResults() {
        return lexResults;
    }

    public void load(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        loadFile = fileChooser.showOpenDialog(primaryStage);
        control.resultTable.setItems(lexResults);
        control.setCode(loadFile);
    }

    public File getLoadFile() {
        return loadFile;
    }
}
