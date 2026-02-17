package stima;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class controller implements Initializable{
    @FXML
    private Button saveBtn;

    @FXML
    private Label timeTaken;

    @FXML
    private Label iterationCount;
    
    @FXML
    private GridPane gridpane;
    
    @FXML
    private Button createBoard;

    @FXML
    private Button inputFile;

    @FXML
    private TextArea inputText;

    @FXML
    private Pane leftPane;

    @FXML
    private Pane rightPane;

    @FXML
    private ChoiceBox<String> selectMethod;
    private String[] iteration_methods = {"bit-like iteration","clock-like iteration","Let It Ride!! (not brute-force)"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        selectMethod.getItems().addAll(iteration_methods);
        inputText.clear();
        filechooser.setInitialDirectory(new File("../Tucil1_13524072/test"));
        saveBtn.setDisable(true);
    }

    @FXML
    private CheckBox showIteration;

    @FXML
    private Button solveBtn;


    matrix current;
    String[] colors = {
        "#9214FA","#5482FB","#7C661E","#682DB1","#575757","#4E8259","#91FF4D","#F2E1A3","#E2E2E2","#6EBE58",
        "#AB4624","#CFA0FB","#DA00F6","#425B98","#EBAE30","#EBAE30","#98AC32","#D42731","#92FFD0","#7FD8FD",
        "#97149C","#AE73A4","#DB22BA","#970066","#F4E342","#D60083"
    };

    FileChooser filechooser = new FileChooser();
    public void selectFile(ActionEvent e){
        filechooser.setTitle("Open a .txt file");
        filechooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File file = filechooser.showOpenDialog(new Stage());
        inputText.clear();
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                inputText.appendText(scanner.nextLine() + "\n");
            }
        } catch (FileNotFoundException r){
            r.printStackTrace();
        }
    }

    public void boarding(ActionEvent e){
        current = the_io.parse_from_string(inputText.getText());
        gridpane.getChildren().clear();
        gridpane.getRowConstraints().clear();
        gridpane.getColumnConstraints().clear();
        for(int i=0;i<current.row;i++){
            RowConstraints temprow = new RowConstraints();
            ColumnConstraints tempcol = new ColumnConstraints();
            temprow.setPercentHeight(100.0/current.row);
            tempcol.setPercentWidth(100.0/current.col);
            gridpane.getRowConstraints().add(temprow);
            gridpane.getColumnConstraints().add(tempcol);
        }
        for(int i=0;i<current.row;i++){
            for(int j=0;j<current.col;j++){
                Pane cell = new Pane();
                String currentColor = colors[Character.getNumericValue(current.data[i][j])-10];
                cell.setBackground(new Background(new BackgroundFill(Color.web(currentColor),CornerRadii.EMPTY,Insets.EMPTY)));
                cell.setStyle("-fx-border-width:1; -fx-border-color:#000000;");
                gridpane.add(cell,j,i);
            }
        }
    }

    ArrayList<cell> seen = new ArrayList<cell>();

    public void solve(ActionEvent e){
        
        String selectedMethod = selectMethod.getValue();
        long start = System.currentTimeMillis();
        current.clock_like(seen, showIteration.isSelected(), this);
        long end = System.currentTimeMillis();
        System.out.println("time taken: " +(end-start) + "ms");
        // if(selectedMethod == "bit-like iteration"){
            
        // }
        // else if(selectedMethod == "bit-like iteration"){

        // }
        // else if(selectedMethod == "bit-like iteration"){
            
        // }
        // else{

        // }
    }

    public void print_queen(ArrayList<cell> arr){
        clear_queens();
        for(int i=0;i<arr.size();i++){
            Pane cell = (Pane) gridpane.getChildren().get(arr.get(i).r * current.col + arr.get(i).c);
            ImageView imageview = new ImageView(new Image("/queen.png"));
            imageview.fitWidthProperty().bind(cell.widthProperty().multiply(0.8));
            imageview.fitHeightProperty().bind(cell.heightProperty().multiply(0.8));
            imageview.setPreserveRatio(true);
            cell.setStyle("-fx-alignment: center;");
            cell.getChildren().add(imageview);
        }
    }

    public void clear_queens(){
        for(int i=0;i<current.row;i++){
            for(int j=0;j<current.col;j++){
                Pane cell = (Pane) gridpane.getChildren().get(i * current.col + j);
                cell.getChildren().clear();
            }
        }
    }
}
